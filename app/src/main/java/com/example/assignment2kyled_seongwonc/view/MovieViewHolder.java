package com.example.assignment2kyled_seongwonc.view;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment2kyled_seongwonc.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    ImageView movieView;
    TextView title;
    TextView year;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieView = itemView.findViewById(R.id.movieview);
        title = itemView.findViewById(R.id.title_txt);
        year = itemView.findViewById(R.id.year_txt);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "onClick: ");
            }
        });
    }
}
