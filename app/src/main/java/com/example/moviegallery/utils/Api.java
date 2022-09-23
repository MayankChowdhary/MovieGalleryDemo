package com.example.moviegallery.utils;

import com.example.moviegallery.models.MovieDetailsModel;
import com.example.moviegallery.models.MovieListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = Constants.BASE_URL;
    @GET("now_playing")
    Call<MovieListModel> getMovieLists(@Query("api_key") String api_key);

    @GET("{id}")
    Call<MovieDetailsModel> getMovieDetails(@Path("id") int id, @Query("api_key") String api_key);
}