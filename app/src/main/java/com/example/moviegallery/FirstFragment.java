package com.example.moviegallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviegallery.databinding.FragmentFirstBinding;
import com.example.moviegallery.models.MovieListModel;
import com.example.moviegallery.utils.Api;
import com.example.moviegallery.utils.Constants;
import com.example.moviegallery.utils.CustomAdapter;
import com.example.moviegallery.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMovieList();
    }

    private void initRecyclerView(ArrayList<MovieListModel.Result> movieList) {
        // get the reference of RecyclerView
        RecyclerView recyclerView = binding.recyclerview;
// set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        recyclerView.hasFixedSize();
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(requireContext(), movieList, FirstFragment.this);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void getMovieList() {
        Call<MovieListModel> call = RetrofitClient.getInstance().getMyApi().getMovieLists(Constants.API_KEY);
        call.enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(@NonNull Call<MovieListModel> call, @NonNull Response<MovieListModel> response) {
                MovieListModel movieData = response.body();
                if (movieData != null) {
                    initRecyclerView(movieData.results);
                } else {
                    Log.d("MovieListResponse: ", "NULL!");
                }
            }

            @Override
            public void onFailure(Call<MovieListModel> call, Throwable t) {
                Toast.makeText(requireContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}