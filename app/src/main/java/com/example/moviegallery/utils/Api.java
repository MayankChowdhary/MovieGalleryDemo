package com.example.moviegallery.utils;

import com.example.moviegallery.models.NewsListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = Constants.BASE_URL;
    @GET("everything")
    Call<NewsListModel> getMovieLists(@Query("q") String category, @Query("from") String fromDate, @Query("sortBy") String sortBy, @Query("apiKey") String api_key);

}