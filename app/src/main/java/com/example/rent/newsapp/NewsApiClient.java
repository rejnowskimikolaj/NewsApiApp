package com.example.rent.newsapp;

import com.example.rent.newsapp.model.AdsResponse;
import com.example.rent.newsapp.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by RENT on 2017-02-02.
 */

public interface NewsApiClient {

    @GET("plugin/test.news")
    @Headers({
            "X-BAASBOX-APPCODE: 1234567890"
    })
    Call<NewsResponse> getNews();

    @GET("/plugin/test.ads")
    @Headers({
            "X-BAASBOX-APPCODE: 1234567890"
    })
    Call<AdsResponse> getAds();




}
