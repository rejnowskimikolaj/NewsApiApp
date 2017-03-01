package com.example.rent.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rent.newsapp.model.AdsData;
import com.example.rent.newsapp.model.NewsData;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetNewsTask.NewsDownloadListener {

    private List<ListItem> itemList;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadNews();
            }
        });

        itemList = new LinkedList<>();
    }

    private void downloadNews() {
        new GetNewsTask(this).execute();

    }


    @Override
    public void onNewsDownloaded(ResultData resultData) {
        Toast.makeText(this,"Downloaded",Toast.LENGTH_SHORT).show();

        setItemList(resultData);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        NewsAdapter adapter = new NewsAdapter(this);
        adapter.setData(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void setItemList(ResultData resultData){

        int counter=0;
        itemList.clear();

        List<AdsData> ads = resultData.getAds();
        List<NewsData> news = resultData.getNews();

        for(NewsData newsData : news){
            itemList.add(itemList.size(),new ListItem.NewsItem(newsData));
        }

        Collections.sort(ads,new Comparator<AdsData>() {
            @Override
            public int compare(AdsData a1, AdsData a2) {
                if (a1.getIndex() > a2.getIndex()) return 1;
                else if (a1.getIndex() < a2.getIndex()) return -1;
                else return 0;
            }
        });

        for(AdsData ad: ads){
            itemList.add(ad.getIndex()+counter, new ListItem.AdsItem(ad));
            counter++;
        }

    }


}
