package com.example.lcy.nbanews.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.lcy.nbanews.R;
import com.example.lcy.nbanews.base.BaseAppCompatActivity;
import com.example.lcy.nbanews.ui.adapter.MyFragmentPageAdapter;
import com.example.lcy.nbanews.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<Fragment> mDatas = new ArrayList<>();

    private List<String> mTitles = new ArrayList<>();

    @Override
    protected boolean swipeBackEnable() {
        return false;
    }

    @Override
    protected void initViewsAndDatas(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setupWithViewPager(mViewPager);

        mDatas.add(NewsFragment.newInstance("news"));
        mDatas.add(NewsFragment.newInstance("blog"));
        mTitles.add("新闻");
        mTitles.add("博客");
        mViewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(), mDatas, mTitles));

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
