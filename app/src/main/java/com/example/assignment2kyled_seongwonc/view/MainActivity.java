package com.example.assignment2kyled_seongwonc.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignment2kyled_seongwonc.R;
import com.example.assignment2kyled_seongwonc.databinding.ActivityMainBinding;
import com.example.assignment2kyled_seongwonc.model.MovieModel;
import com.example.assignment2kyled_seongwonc.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
MovieViewModel viewModel;
List<MovieModel> movieList = new ArrayList<>();
MyAdapter myAdapter;
EditText searchTxt;

ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myAdapter = new MyAdapter(MainActivity.this, movieList);
        binding.recyclerView.setAdapter(myAdapter);

        searchTxt = findViewById(R.id.searchField);

       //setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.getMovieData().observe(this, movieData-> {
            Log.i("tag", "Update View ");
            movieList.clear();
            movieList.addAll(movieData);

            myAdapter.notifyDataSetChanged();

        });


        binding.searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String query = searchTxt.getText().toString().trim();
                if (!query.isEmpty()) {
                    viewModel.Search(query);
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

}