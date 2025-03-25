package com.example.assignment2kyled_seongwonc.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.assignment2kyled_seongwonc.R;

public class MovieDetailsActivity extends AppCompatActivity {
    ImageView moviePoster;
    TextView movieTitle, movieYear, movieType;
    Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        moviePoster = findViewById(R.id.detail_poster);
        movieTitle = findViewById(R.id.detail_title);
        movieYear = findViewById(R.id.detail_year);
        backButton = findViewById(R.id.back_Button);
        movieType = findViewById(R.id.detail_type);

        String title = getIntent().getStringExtra("title");
        String year = getIntent().getStringExtra("year");
        String poster = getIntent().getStringExtra("poster");
        String type = getIntent().getStringExtra("type");


        movieTitle.setText(title);
        movieYear.setText(year);
        Glide.with(this).load(poster).into(moviePoster);
        movieType.setText(type);

        backButton.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());
    }
}
