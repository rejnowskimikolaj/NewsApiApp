package com.example.rent.newsapp.model;

import java.util.List;

/**
 * Created by RENT on 2017-02-02.
 */

public class AdsResponse {
    String result;
    List<AdsData> data;

    public String getResult() {
        return result;
    }

    public List<AdsData> getData() {
        return data;
    }
}
