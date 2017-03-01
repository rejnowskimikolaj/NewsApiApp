package com.example.rent.newsapp.model;

import java.util.List;

/**
 * Created by RENT on 2017-02-02.
 */

public class NewsResponse {

    String result;
    List<NewsData> data;

    public String getResult() {
        return result;
    }

    public List<NewsData> getData() {
        return data;
    }
}
