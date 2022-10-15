package com.example.moviegallery.utils;

import android.content.Context;
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
import com.example.moviegallery.FirstFragmentDirections;
import com.example.moviegallery.R;
import com.example.moviegallery.models.NewsListModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<NewsListModel.Article> movieList;
    Context context;
    Fragment fragment;

    public CustomAdapter(Context context, ArrayList<NewsListModel.Article> movieList, Fragment fragment) {
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
        holder.category.setText(movieList.get(pos).author);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
        String date = dateFormat.format(movieList.get(pos).publishedAt);
        holder.date.setText(date);
        // holder.image.setImageResource(movieList.get(pos).title);
        // implement setOnClickListener event on item view.
        loadImage(holder.image, movieList.get(pos).urlToImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click

                NavHostFragment.findNavController(fragment)
                        .navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(movieList.get(pos).title,movieList.get(pos).content,date,movieList.get(pos).author,movieList.get(pos).urlToImage));

            }
        });

    }

    private void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url) // image url
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
        TextView category;
        TextView date;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            category = (TextView) itemView.findViewById(R.id.category);
            date = (TextView) itemView.findViewById(R.id.date);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
