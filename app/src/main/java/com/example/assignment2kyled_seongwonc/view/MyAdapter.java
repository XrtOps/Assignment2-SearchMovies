package com.example.assignment2kyled_seongwonc.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment2kyled_seongwonc.R;
import com.example.assignment2kyled_seongwonc.model.MovieModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    List<MovieModel> movies;
    Context context;

    public MyAdapter(Activity activity, List<MovieModel> movies) {
        this.context = activity;
        this.movies = movies;
    }



    @NonNull
    @Override

    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        Glide.with(context)
                .load(movie.getPoster())
                .into(holder.movieView);

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("title", movie.getTitle());
            intent.putExtra("year", movie.getYear());
            intent.putExtra("poster", movie.getPoster());
            intent.putExtra("type", movie.getType());

            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
