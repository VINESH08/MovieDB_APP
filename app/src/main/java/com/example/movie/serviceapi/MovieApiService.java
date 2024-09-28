package com.example.movie.serviceapi;

import com.example.movie.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    //This defines the structure of the api and acts as bridge bw app and api
    //Network Transactions
    @GET("movie/popular") //Get The popular movies(end point) from the server to display it
    Call<Result> getPopularMovies(@Query("api_key")String apikey);//Whenever i request popular movies i need to specify the api key as the parameter

}

