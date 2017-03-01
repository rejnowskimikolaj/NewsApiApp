package com.example.rent.newsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RENT on 2017-02-02.
 */

public class NewsData {

    String title;
    String content;
    @SerializedName("imageUrl")
    String url;
    int index;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public int getIndex() {
        return index;
    }
}
