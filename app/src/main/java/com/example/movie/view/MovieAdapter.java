package com.example.movie.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.databinding.MovieListLayoutBinding;
import com.example.movie.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListLayoutBinding movieListLayoutBinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_layout,
                parent,
                false
        );
        return new MovieViewHolder(movieListLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie=movieArrayList.get(position);
        holder.movieListLayoutBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        private MovieListLayoutBinding movieListLayoutBinding;

        public MovieViewHolder(MovieListLayoutBinding movieListLayoutBinding) {
            super(movieListLayoutBinding.getRoot());
            this.movieListLayoutBinding = movieListLayoutBinding;
            movieListLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                }
            });
        }
    }
}
