package com.example.movie;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.movie.databinding.ActivityMainBinding;
import com.example.movie.model.Movie;
import com.example.movie.view.MovieAdapter;
import com.example.movie.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie>movieArrayList;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding layoutBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

         layoutBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
         mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);//Provie instance of the main activity
         //View Model Provider is used to create and return the instances
        //Get Method tells the view model provider to create new instance if it dosen't exist or return the existing one

        getPopularMovies();
        swipeRefreshLayout=layoutBinding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);//Used for loader(coloring purpose)
        //Common component to implement pull to refresh gesture
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });

    }

    private void getPopularMovies() {
        mainActivityViewModel.getmovies().observe(this, new Observer<List<Movie>>() {//this->lifecycle owner
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movieArrayList=(ArrayList<Movie>) moviesFromLiveData;
                displayMoviesinRecycerView();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    private void displayMoviesinRecycerView() {
        recyclerView=layoutBinding.recyclerview;
        movieAdapter=new MovieAdapter(this,movieArrayList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        movieAdapter.notifyDataSetChanged();
    }

}