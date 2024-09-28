package com.example.movie.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movie.R;
import com.example.movie.serviceapi.MovieApiService;
import com.example.movie.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieRepository {
    //used to abstract the data source and provide clean API for the view model to fetch and manage data
    private ArrayList<Movie> movies=new ArrayList<>();
    private MutableLiveData<List<Movie>>mutableLiveData=new MutableLiveData<>();//used to observe the data changes(Mutable live data is
    //an extension of Live Data modify or set the contained data
    private Application application;//used to access the application context from the resource file

    public MovieRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Movie>>getMutableLiveData(){
        MovieApiService movieApiService= RetrofitInstance.getService();
        Call<Result> call=movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        //make network request in background thread and handel response in the main UI thread
        //Two Methods ->Enqueue and Execute both are used to make network request in background thread but the difference is execute is executed in the main thread
        call.enqueue(new Callback<Result>() {
            //Success
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result=response.body();
                if(result!=null&& result.getResults()!=null){
                    movies= (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });
        return mutableLiveData;
    }
}
