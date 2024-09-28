package com.example.movie.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie.model.Movie;
import com.example.movie.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    //ViewModel ->used for nonandroid specific logic
    //AndroidViewModel -> used for android specific logic
    private MovieRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MovieRepository(application);
    }
    public LiveData<List<Movie>>getmovies(){
        return repository.getMutableLiveData();
    }
}

