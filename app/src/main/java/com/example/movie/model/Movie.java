package com.example.movie.model; ;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.example.movie.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Movie extends BaseObservable {
//When u enable base observable u automatically enable databinding

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("overview")
    @Expose
    private String overview;



    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @BindingAdapter({"posterPath"})//BindingAdapter is used to define custom attribute in xml
    public static void loadImage(ImageView view, String imageUrl){
        //Basic Url=https://image.tmdb.org/t/p/w500
        String url="https://image.tmdb.org/t/p/w500"+imageUrl;//BaseURl+FileSize+imageUrl
        Glide.with(view.getContext()).load(url).into(view);//Glide is a image loading library

    }
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("title")
    @Expose
    private String title;



    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }





    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }



    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Bindable //Bindable to ui component
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }


    @Bindable
    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        notifyPropertyChanged(BR.voteAverage);//notify to ui component Br->binding Resource
        //Any ui element bound to this property will automatically update the ui to reflect new value
    }

   
}