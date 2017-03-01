package com.example.rent.newsapp;

import com.example.rent.newsapp.model.AdsData;
import com.example.rent.newsapp.model.NewsData;

import java.util.List;

/**
 * Created by RENT on 2017-02-02.
 */

public class ResultData {

    List<AdsData> ads;
    List<NewsData> news;

    public ResultData(List<AdsData> ads, List<NewsData> news) {
        this.ads = ads;
        this.news = news;
    }

    public List<AdsData> getAds() {
        return ads;
    }

    public List<NewsData> getNews() {
        return news;
    }
}
