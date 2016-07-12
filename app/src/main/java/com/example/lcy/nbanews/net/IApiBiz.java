package com.example.lcy.nbanews.net;

import com.example.lcy.nbanews.entity.NBANewsEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lcy on 2016-5-12.
 */
public interface IApiBiz {
    // http://nbaplus.sinaapp.com/api/v1.0/news/update
    @GET("/api/v1.0/{type}/update")
    Call<NBANewsEntity> getLatestData(@Path("type") String type);

    @GET("/api/v1.0/{type}/loadmore/{id}")
    Call<NBANewsEntity> getMoreData(@Path("type") String type, @Path("id") String id);

}
