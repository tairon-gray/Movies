package com.evg_ivanoff.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.evg_ivanoff.movies.data.Movie;
import com.evg_ivanoff.movies.utils.JsonUtils;
import com.evg_ivanoff.movies.utils.NetworkUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPosters;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPosters = findViewById(R.id.recyclerViewPosters);
        recyclerViewPosters.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MovieAdapter();
        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(NetworkUtils.POPULARITY, 1);
        ArrayList<Movie> movies = JsonUtils.getMoviesFromJSON(jsonObject);
        adapter.setMovies(movies);
        recyclerViewPosters.setAdapter(adapter);
    }
}