package com.lemondstudio.blockbuster.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lemondstudio.blockbuster.R;
import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieResult;
import com.lemondstudio.blockbuster.View.Adapter.TopRatedMovieListAdapter;
import com.lemondstudio.blockbuster.ViewModel.TopRatedMovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //create instance for TopRatedMovieListViewModel (ViewModel) class
    private TopRatedMovieListViewModel trmViewModel;
    //create instance for TopRatedMovieListAdapter class
    private TopRatedMovieListAdapter topRatedMovieListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect with xml recyclerView
        recyclerView = findViewById(R.id.recyclerview);
        //create object for GridLayoutManager
        GridLayoutManager LayoutManager = new GridLayoutManager(this, 2);
        //setup GridLayoutManager with recyclerView
        recyclerView.setLayoutManager(LayoutManager);
        //initiate the view model as view model object
        trmViewModel = new ViewModelProvider(this).get(TopRatedMovieListViewModel.class);
        //Observ the view model get method which will show data
        trmViewModel.getTopRatedMovieLists().observe(this, new Observer<List<TopRatedMovieResult>>() {
            @Override
            public void onChanged(List<TopRatedMovieResult> topRatedMovieResults) {

                //create object for Adapter and pass param
                topRatedMovieListAdapter = new TopRatedMovieListAdapter(MainActivity.this, topRatedMovieResults);
                //set Adapter inside the recyclerView
                recyclerView.setAdapter(topRatedMovieListAdapter);
            }
        });



    }
}