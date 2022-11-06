package com.lemondstudio.blockbuster.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lemondstudio.blockbuster.R;
import com.lemondstudio.blockbuster.Service.Model.TopRatedMovieResult;

import java.util.List;

public class TopRatedMovieListAdapter extends RecyclerView.Adapter<TopRatedMovieListAdapter.TopRatedMovieViewHolder>{

    //create instance
    private Context trmContext;
    private List<TopRatedMovieResult> trmList;

    //constructor method for TopRatedMovieListAdapter class
    public TopRatedMovieListAdapter(Context trmContext, List<TopRatedMovieResult> trmList) {
        this.trmContext = trmContext;
        this.trmList = trmList;
    }

    @NonNull
    @Override
    public TopRatedMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //connect single view layout component with adapter
       View trmSingleView = LayoutInflater.from(trmContext).inflate(R.layout.movie_single_row, parent, false);
        return new TopRatedMovieViewHolder(trmSingleView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedMovieViewHolder holder, int position) {

        //bind dynamic data with view
        holder.trmTitle.setText(trmList.get(position).getTitle());
        holder.trmRating.setText(trmList.get(position).getVoteAverage().toString());
        holder.trmReleaseDate.setText(trmList.get(position).getReleaseDate());
        //for display image
        Glide.with(trmContext).load("https://image.tmdb.org/t/p/w500"+ trmList.get(position).getPosterPath()).into(holder.trmImageView);

    }

    @Override
    public int getItemCount() {

        if(this.trmList !=null)
        {
            return trmList.size();
        } else {
            return 0;
        }
    }

    //create view holder class
    public class TopRatedMovieViewHolder extends RecyclerView.ViewHolder {

        //component instance
        ImageView trmImageView;
        TextView trmTitle, trmRating, trmReleaseDate;

        //constructor method for TopRatedMovieViewHolder class
        public TopRatedMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            //initiate xml id
            trmTitle = itemView.findViewById(R.id.title);
            trmRating = itemView.findViewById(R.id.rating);
            trmReleaseDate = itemView.findViewById(R.id.release_date);
            trmImageView = itemView.findViewById(R.id.avatar);

        }

    }


}
