package com.example.moviegallery;

import static com.example.moviegallery.utils.Constants.POSTER_BASE_URL;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.moviegallery.databinding.FragmentSecondBinding;
import com.example.moviegallery.models.MovieDetailsModel;
import com.example.moviegallery.models.MovieListModel;
import com.example.moviegallery.utils.Constants;
import com.example.moviegallery.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private int movieId;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        movieId = SecondFragmentArgs.fromBundle(getArguments()).getMovieId();
        Log.d("MovieDetails", "onCreateView: ID: " + movieId);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMovieDetails();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getMovieDetails() {
        Call<MovieDetailsModel> call = RetrofitClient.getInstance().getMyApi().getMovieDetails(movieId,Constants.API_KEY);
        call.enqueue(new Callback<MovieDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetailsModel> call, @NonNull Response<MovieDetailsModel> response) {
                MovieDetailsModel movieData = response.body();
                if (movieData != null) {
                    updateMovieUi(movieData);
                    Log.d("MovieDetails", "onResponse: "+movieData);
                } else {
                    Log.d("MovieListResponse: ", "NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieDetailsModel> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
    private void updateMovieUi(MovieDetailsModel movieDetailsModel){
        binding.textviewMovieDetails.setText(movieDetailsModel.toString());
            Glide.with(binding.movieDetailsPoster)
                    .load(POSTER_BASE_URL + movieDetailsModel.poster_path) // image url
                    .placeholder(R.drawable.no_picture) // any placeholder to load at start
                    .error(R.drawable.no_picture)  // any image in case of error
                    .into(binding.movieDetailsPoster);
    }

}