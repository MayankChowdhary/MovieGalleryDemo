package com.example.moviegallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.moviegallery.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String title;
    private String content;
    private String date;
    private String category;
    private String image;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        title = SecondFragmentArgs.fromBundle(getArguments()).getTitle();
        category = SecondFragmentArgs.fromBundle(getArguments()).getCategory();
        content = SecondFragmentArgs.fromBundle(getArguments()).getContent();
        image = SecondFragmentArgs.fromBundle(getArguments()).getImage();
        date = SecondFragmentArgs.fromBundle(getArguments()).getDate();
        Log.d("MovieDetails", "onCreateView: Title: " + title);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateMovieUi();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void updateMovieUi(){
        binding.textviewMovieDetails.setText(content+content+content+content+content);
        binding.title.setText(title);
        binding.date.setText(date);
        binding.category.setText(category);
            Glide.with(binding.movieDetailsPoster)
                    .load(image) // image url
                    .placeholder(R.drawable.no_picture) // any placeholder to load at start
                    .error(R.drawable.no_picture)  // any image in case of error
                    .into(binding.movieDetailsPoster);
    }

}