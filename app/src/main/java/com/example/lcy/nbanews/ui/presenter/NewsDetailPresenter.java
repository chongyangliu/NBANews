package com.example.lcy.nbanews.ui.presenter;

import com.example.lcy.nbanews.entity.NBADetailEntity;
import com.example.lcy.nbanews.net.OkHttpUtils;
import com.example.lcy.nbanews.ui.view.NewsDetailView;
import com.example.lcy.nbanews.util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class NewsDetailPresenter {
    private NewsDetailView mNewsDetailView;

    public NewsDetailPresenter(NewsDetailView newsDetailView) {
        mNewsDetailView = newsDetailView;
    }
    public void getNewsDetails (String url){
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NBADetailEntity nbaDetailEntity = readJsonNewsDetailBeans(response);
                mNewsDetailView.setNewsContent(nbaDetailEntity.getContent());
            }

            @Override
            public void onFailure(Exception e) {
                mNewsDetailView.showErrorMsg(e.getMessage());
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    public static NBADetailEntity readJsonNewsDetailBeans(String res) {
        NBADetailEntity nbaDetailEntity = null;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            nbaDetailEntity = JsonUtils.deserialize(parser.parse(res).getAsJsonObject(), NBADetailEntity.class);
        } catch (Exception e) {

        }
        return nbaDetailEntity;
    }
}
