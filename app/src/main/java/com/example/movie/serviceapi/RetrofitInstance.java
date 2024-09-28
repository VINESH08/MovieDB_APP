package com.example.movie.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    //The Retrofit lib used to make Http request to the web and how to handel them
    private static Retrofit retrofit=null;
    private static String BASE_URL="https://api.themoviedb.org/3/";
    public static MovieApiService getService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();//For serializing and deserializing JSON
        }
        return retrofit.create(MovieApiService.class);//Create an implementation of the API endpoints
    }
}

