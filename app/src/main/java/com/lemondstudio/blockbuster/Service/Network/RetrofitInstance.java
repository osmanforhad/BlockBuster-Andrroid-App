package com.lemondstudio.blockbuster.Service.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //instance variable
    public static String BASE_URL = "https://api.themoviedb.org/";
    //create retrofit instance as SingleTone Design Pattern Rules
    private static Retrofit retrofit;

    //create public static method which type is Retrofit Class as SingleTone Design Pattern Rules
    public static Retrofit getRetroInstance()
    {
        if(retrofit == null)
        {
            //initiate the Retrofit object
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;

    }


}
