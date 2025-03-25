package com.example.assignment2kyled_seongwonc.viewmodel;



import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignment2kyled_seongwonc.model.MovieModel;
import com.example.assignment2kyled_seongwonc.utils.ApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieViewModel extends ViewModel {

    private final MutableLiveData<List<MovieModel>> movieData = new MutableLiveData<>();

//    MovieModel movieModel = new MovieModel();

    public LiveData<List<MovieModel>> getMovieData () {
        return movieData;
    }


    public void Search(String movieName) {

        String urlString ="https://www.omdbapi.com/?apikey=8cef4260&s=" + movieName;

        ApiClient.get(urlString, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("API Error", "Request is failed: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                assert response.body() != null;
                String responseData = response.body().string();
                Log.d("API Response", responseData);

                try {
                    JSONObject json = new JSONObject(responseData);
                    if(json.has("Search")) {
                        JSONArray moviesArray = json.getJSONArray("Search");
                        List<MovieModel> movieList = new ArrayList<>();


                        for (int i = 0; i < moviesArray.length(); i++){
                            JSONObject movieJson = moviesArray.getJSONObject(i);
                            MovieModel movie = new MovieModel(
                                    movieJson.getString("Title"),
                                    movieJson.getString("Year"),
                                    movieJson.getString("Type"),
                                    movieJson.getString("Poster")
                            );
                            movieList.add(movie);
                        }
                        movieData.postValue(movieList);

                    }


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


}

