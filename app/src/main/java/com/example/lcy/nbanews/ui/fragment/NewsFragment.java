package com.example.lcy.nbanews.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lcy.nbanews.R;
import com.example.lcy.nbanews.base.BaseFragment;
import com.example.lcy.nbanews.entity.NBANewsEntity;
import com.example.lcy.nbanews.ui.activity.MainActivity;
import com.example.lcy.nbanews.ui.activity.NewsDetailActivity;
import com.example.lcy.nbanews.ui.adapter.NBANewsAdapter;
import com.example.lcy.nbanews.ui.presenter.NewsPresenter;
import com.example.lcy.nbanews.ui.view.NewsView;
import com.example.lcy.nbanews.util.ColorUtils;
import com.example.lcy.nbanews.util.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class NewsFragment extends BaseFragment implements NewsView, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnRecyclerViewItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {
    private static final int PAGE_SIZE = 10;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private NewsPresenter mNewsPresenter;

    private ProgressDialog mProgressDialog;

    private List<NBANewsEntity.NewslistBean> mDatas = new ArrayList<>();

    private NBANewsAdapter mAdapter;

    private String mType;

    private String mNextId;

    public static NewsFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    @Override
    protected void initViewsAndDatas(Bundle savedInstanceState) {
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("加载中...");
        mProgressDialog.setCancelable(true);

        mSwipeRefreshLayout.setColorSchemeColors(ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor());
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setBackgroundColor(Color.parseColor("#fafafa"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new NBANewsAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnRecyclerViewItemClickListener(this);
        mAdapter.setOnLoadMoreListener(this);
        mAdapter.openLoadMore(PAGE_SIZE, true);

        mType = getArguments().getString("type");
        mNewsPresenter = new NewsPresenter(this);
        mNewsPresenter.requestLatestData(mType, true);

        View customLoading = LayoutInflater.from(mContext).inflate(R.layout.custom_loading, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setLoadingView(customLoading);

        ((MainActivity) mContext).findViewById(R.id.toolBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showProgressDialog() {
        if (! mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void setList(NBANewsEntity nbaNewsEntity, boolean isRefresh) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        if (isRefresh) {
            mDatas.clear();
        }
        for (NBANewsEntity.NewslistBean newslistBean : nbaNewsEntity.getNewslist()) {
            if (newslistBean.getImgUrlList().size() == 0) {
                newslistBean.setItemType(NBANewsAdapter.TEXT);
            } else if (newslistBean.getImgUrlList().size() == 1) {
                newslistBean.setItemType(NBANewsAdapter.IMG);
            } else {
                newslistBean.setItemType(NBANewsAdapter.MORE_IMG);
            }
        }
        mNextId = nbaNewsEntity.getNextId();
        mAdapter.notifyDataChangedAfterLoadMore(nbaNewsEntity.getNewslist(), true);
    }

    @Override
    public void showErrorMsg(String msg) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        SnackBarUtils.showSnackBar(mSwipeRefreshLayout, msg);
    }

    @Override
    public void onRefresh() {
        mNewsPresenter.requestLatestData(mType, false);
    }

    @Override
    public void onItemClick(View view, int i) {
        Intent intent = new Intent(mContext, NewsDetailActivity.class);
        intent.putExtra("data", mDatas.get(i));
        startActivity(intent);
    }

    @Override
    public void onLoadMoreRequested() {
        mNewsPresenter.requestMoreData(mType, mNextId, false);
    }
}
