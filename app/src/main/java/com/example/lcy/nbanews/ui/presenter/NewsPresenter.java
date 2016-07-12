package com.example.lcy.nbanews.ui.presenter;

import com.example.lcy.nbanews.entity.NBANewsEntity;
import com.example.lcy.nbanews.net.ApiFactory;
import com.example.lcy.nbanews.ui.view.NewsView;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class NewsPresenter {
    private static final String TAG = "NewsPresenter";
    private NewsView mNewsView;

    public NewsPresenter(NewsView newsView) {
        mNewsView = newsView;

    }

    public void requestLatestData(String type, boolean showProgressDialog) {
        if (showProgressDialog) {
            mNewsView.showProgressDialog();
        }
        ApiFactory.INSTANCE.getAPI().getLatestData(type).enqueue(new Callback<NBANewsEntity>() {
            @Override
            public void onResponse(Call<NBANewsEntity> call, Response<NBANewsEntity> response) {
                mNewsView.hideProgressDialog();
                Logger.e(TAG, call.request().url());
                if (response.code() == 200) {
                    mNewsView.setList(response.body(), true);
                } else {
                    mNewsView.showErrorMsg(response.message());
                }
            }

            @Override
            public void onFailure(Call<NBANewsEntity> call, Throwable t) {
                mNewsView.hideProgressDialog();
                mNewsView.showErrorMsg(t.getLocalizedMessage());
            }
        });

    }


    public void requestMoreData(String type, String nextId, boolean showProgressDialog) {
        if (showProgressDialog) {
            mNewsView.showProgressDialog();
        }
        ApiFactory.INSTANCE.getAPI().getMoreData(type, nextId).enqueue(new Callback<NBANewsEntity>() {
            @Override
            public void onResponse(Call<NBANewsEntity> call, Response<NBANewsEntity> response) {
                mNewsView.hideProgressDialog();
                Logger.e(TAG, call.request().url());
                if (response.code() == 200) {
                    mNewsView.setList(response.body(), false);
                } else {
                    mNewsView.showErrorMsg(response.message());
                }
            }

            @Override
            public void onFailure(Call<NBANewsEntity> call, Throwable t) {
                mNewsView.hideProgressDialog();
                mNewsView.showErrorMsg(t.getLocalizedMessage());
            }
        });

    }
}
