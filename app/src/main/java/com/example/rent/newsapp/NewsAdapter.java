package com.example.rent.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rent.newsapp.model.AdsData;
import com.example.rent.newsapp.model.NewsData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RENT on 2017-02-02.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ListItem> items = new LinkedList<>();
    Context context;

    public NewsAdapter(Context context){
        this.context= context;

    }


    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            return new NewsAdapter.NewsViewHolder(view);
        }

        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_item, parent, false);
            return new NewsAdapter.AdViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);



        if(viewType==1){

            holder = (NewsViewHolder) holder;
            ListItem.NewsItem data = (ListItem.NewsItem) items.get(position);
            NewsData newsData = (NewsData) data.getItem();
            String title = newsData.getTitle();
            String content = newsData.getContent();
            String url = newsData.getUrl();


            ((NewsViewHolder) holder).content.setText(content);
            ((NewsViewHolder) holder).title.setText(title);
            ((NewsViewHolder) holder).content.setText(content);



            Picasso.with(context)
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(((NewsViewHolder) holder).imageView);
        }

        else {
            ListItem.AdsItem data = (ListItem.AdsItem) items.get(position);
            AdsData adsData = (AdsData) data.getItem();
            holder = (AdViewHolder) holder;
            ((AdViewHolder) holder).ad.setText(adsData.getAdContent());
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<ListItem> items){
        this.items=items;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView content;
        private ImageView imageView;


        public NewsViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.news_item_title_textView);
            content = (TextView) v.findViewById(R.id.news_item_content_textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public static class AdViewHolder extends RecyclerView.ViewHolder {

        private TextView ad;



        public AdViewHolder(View v) {
            super(v);
            ad = (TextView) v.findViewById(R.id.ad_item);

        }
    }
}
