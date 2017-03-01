package com.example.rent.newsapp;

import android.os.AsyncTask;

import com.example.rent.newsapp.model.AdsData;
import com.example.rent.newsapp.model.AdsResponse;
import com.example.rent.newsapp.model.NewsData;
import com.example.rent.newsapp.model.NewsResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by RENT on 2017-02-02.
 */

public class GetNewsTask extends AsyncTask<Void,Void,ResultData> {

    private final NewsApiClient newsApiClient;
    private NewsDownloadListener listener;


    public GetNewsTask(NewsDownloadListener listener){

        NewsApiClientFactory factory = new NewsApiClientFactory();
        newsApiClient= factory.create();
        this.listener=listener;
    }

    @Override
    protected ResultData doInBackground(Void... voids) {

        try {
            List<NewsData> newsData = getNews();
            List<AdsData> adsData = getAds();
            return new ResultData(adsData,newsData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<NewsData> getNews() throws IOException {
        Call<NewsResponse> call = newsApiClient.getNews();
        Response<NewsResponse> response = call.execute();
        if(response.isSuccessful()) { //http 200+
            NewsResponse newsResponse = response.body();
            return newsResponse.getData();
        }
        return null;

    }

    public List<AdsData> getAds() throws IOException {
        Call<AdsResponse> call = newsApiClient.getAds();
        Response<AdsResponse> response = call.execute();
        if(response.isSuccessful()) { //http 200+
            AdsResponse adsResponse = response.body();
            return adsResponse.getData();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ResultData resultData) {
        listener.onNewsDownloaded(resultData);
    }

    public interface NewsDownloadListener{
        public void onNewsDownloaded(ResultData resultData);
    }
}
