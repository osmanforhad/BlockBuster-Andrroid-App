package com.lemondstudio.blockbuster.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.lemondstudio.blockbuster.Service.API.ApiServiceInterface;
import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieModel;
import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieResult;
import com.lemondstudio.blockbuster.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlockBusterRepository implements BlockBusterRepositoryInterface{

    //instance variable
    private static Context bbmcontext;
    private TopRatedMovieModel movieModel;
    private List<TopRatedMovieResult> topRatedResult;
    private MutableLiveData mLiveData;
    //create BlockBusterRepository class instance as SingleTone Design Pattern Rules
    private static BlockBusterRepository blockBusterRepository;

    //method for show context message
    public static BlockBusterRepository getInstance(Context context)
    {
        if(blockBusterRepository == null)
        {
            //assign the context local to global
            bbmcontext = context;
            //create object instance as SingleTone Design Pattern Rules
            blockBusterRepository = new BlockBusterRepository();
        }

        return blockBusterRepository;
    }

    //method for show top rated movie list
    @Override
    public MutableLiveData<List<TopRatedMovieResult>>  getTopRatedMovieLists()
    {
        if(mLiveData == null)
        {
            //create object for LiveData
            mLiveData = new MutableLiveData();
        }

        //create api service
        ApiServiceInterface apiServiceInterface = RetrofitInstance.getRetroInstance().create(ApiServiceInterface.class);

        Call<TopRatedMovieModel> call = apiServiceInterface.getTopRatedMovieLists();
        call.enqueue(new Callback<TopRatedMovieModel>() {
            @Override
            public void onResponse(Call<TopRatedMovieModel> call, Response<TopRatedMovieModel> response) {

                movieModel = response.body();
              topRatedResult = movieModel.getResults();
                //post Top Rated Movie lists into screen
                mLiveData.postValue(topRatedResult);

            }

            @Override
            public void onFailure(Call<TopRatedMovieModel> call, Throwable t) {

            }
        });

        return mLiveData;
    }


}
