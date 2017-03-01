package com.example.rent.newsapp;

import com.example.rent.newsapp.model.AdsData;
import com.example.rent.newsapp.model.NewsData;

/**
 * Created by RENT on 2017-02-02.
 */

public abstract class ListItem <T> {

    private int type;
    private T item;

    public ListItem(int type, T item) {
        this.type = type;
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public int getType() {
        return type;
    }

    public static class NewsItem extends ListItem<NewsData>{

        public NewsItem( NewsData item) {
            super(1, item);
        }
    }

    public static class AdsItem extends ListItem<AdsData>{

        public AdsItem( AdsData item) {
            super(2, item);
        }
    }
}
