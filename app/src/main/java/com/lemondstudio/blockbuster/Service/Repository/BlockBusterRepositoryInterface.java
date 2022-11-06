package com.lemondstudio.blockbuster.Service.Repository;

import androidx.lifecycle.MutableLiveData;

import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieResult;

import java.util.List;

public interface BlockBusterRepositoryInterface {

    public MutableLiveData<List<TopRatedMovieResult>> getTopRatedMovieLists();

}
