package com.example.moviegallery.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;


public class NewsListModel {
    public String status;
    public int totalResults;
    public ArrayList<Article> articles;

    public class Source {
        public String id;
        public String name;
    }

    public class Article {
        public Source source;
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public Date publishedAt;
        public String content;
    }

}