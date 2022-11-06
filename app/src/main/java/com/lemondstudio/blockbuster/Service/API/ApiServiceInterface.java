package com.lemondstudio.blockbuster.Service.API;

import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceInterface {

    //API ENDPOINTS instance variable
    public static String TOP_RATED_MOVIE = "3/movie/top_rated?api_key=0324f76c90741e1b1cea18c59c9ae878";

    //REQUEST TOP_RATED_MOVIE API END POINT
    @GET(TOP_RATED_MOVIE)
    Call<TopRatedMovieModel> getTopRatedMovieLists();


}
