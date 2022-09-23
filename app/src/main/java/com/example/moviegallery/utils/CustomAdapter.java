package com.example.moviegallery.utils;

import static com.example.moviegallery.utils.Constants.POSTER_BASE_URL;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviegallery.FirstFragment;
import com.example.moviegallery.FirstFragmentDirections;
import com.example.moviegallery.R;
import com.example.moviegallery.models.MovieListModel;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<MovieListModel.Result> movieList;
    Context context;
    Fragment fragment;

    public CustomAdapter(Context context, ArrayList<MovieListModel.Result> movieList,Fragment fragment) {
        this.context = context;
        this.movieList = movieList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        int pos = holder.getAdapterPosition();
        holder.name.setText(movieList.get(pos).title);
        // holder.image.setImageResource(movieList.get(pos).title);
        // implement setOnClickListener event on item view.
        loadImage(holder.image, movieList.get(pos).poster_path);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click

                NavHostFragment.findNavController(fragment)
                        .navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(movieList.get(pos).id));

            }
        });

    }

    private void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(POSTER_BASE_URL + url) // image url
                .placeholder(R.drawable.no_picture) // any placeholder to load at start
                .error(R.drawable.no_picture)  // any image in case of error
                .centerCrop()
                .into(imageView);
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
