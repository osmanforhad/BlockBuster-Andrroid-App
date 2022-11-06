package com.lemondstudio.blockbuster.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieResult;
import com.lemondstudio.blockbuster.Service.Repository.BlockBusterRepository;
import com.lemondstudio.blockbuster.Service.Repository.BlockBusterRepositoryInterface;

import java.util.List;

public class TopRatedMovieListViewModel extends AndroidViewModel {

    //create instance for BlockBusterRepositoryInterface class
    private BlockBusterRepositoryInterface bbRepo;

    //constructor method
    public TopRatedMovieListViewModel(@NonNull Application application) {
        super(application);
        //create object and initial with calling the method
        bbRepo = BlockBusterRepository.getInstance(application);
    }

    //method for get all Top Rated Movie inside LiveData
    public LiveData<List<TopRatedMovieResult>> getTopRatedMovieLists()
    {
        return bbRepo.getTopRatedMovieLists();
    }

}
