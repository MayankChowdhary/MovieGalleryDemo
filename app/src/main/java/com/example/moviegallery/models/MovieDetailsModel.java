package com.example.moviegallery.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class MovieDetailsModel {
    public boolean adult;
    public String backdrop_path;
    public BelongsToCollection belongs_to_collection;
    public int budget;
    public ArrayList<Genre> genres;
    public String homepage;
    public int id;
    public String imdb_id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public ArrayList<ProductionCompany> production_companies;
    public ArrayList<ProductionCountry> production_countries;
    public String release_date;
    public int revenue;
    public int runtime;
    public ArrayList<SpokenLanguage> spoken_languages;
    public String status;
    public String tagline;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;

    public static class ProductionCountry {
        public String iso_3166_1;
        public String name;

        @NonNull
        @Override
        public String toString() {
            return "ProductionCountry" +'\n'  +'\n'  +
                    "iso_3166_1= " + iso_3166_1 + '\n' +'\n'  +
                    "name= " + name + '\n' +'\n'  +
                    '\n'+'\n'    ;
        }
    }

    public static class SpokenLanguage {
        public String english_name;
        public String iso_639_1;
        public String name;

        @NonNull
        @Override
        public String toString() {
            return "SpokenLanguage" +'\n'  +'\n'  +
                    "english_name= " + english_name + '\n' +'\n'  +
                    "iso_639_1= " + iso_639_1 + '\n' +'\n'  +
                    "name= " + name + '\n' +'\n'  +
                    '\n'  ;
        }
    }


    public static class ProductionCompany {
        public int id;
        public String logo_path;
        public String name;
        public String origin_country;

        @NonNull
        @Override
        public String toString() {
            return "ProductionCompany" +'\n'  +'\n'  +
                    "id=" + id +'\n'  +'\n'  +
                    "logo_path= " + logo_path + '\n' +'\n'  +
                    "name= " + name + '\n' +'\n'  +
                    "origin_country= " + origin_country + '\n' +'\n'  +
                    '\n'  ;
        }
    }

    public static class BelongsToCollection {
        public int id;
        public String name;
        public String poster_path;
        public String backdrop_path;

        @NonNull
        @Override
        public String toString() {
            return "BelongsToCollection" +'\n'  +'\n'  +
                    "id=" + id +'\n'  +'\n'  +
                    "name= " + name + '\n' +'\n'  +
                    "poster_path= " + poster_path + '\n' +'\n'  +
                    "backdrop_path= " + backdrop_path + '\n' +'\n'  +
                    '\n'  ;
        }
    }

    public static class Genre {
        public int id;
        public String name;

        @NonNull
        @Override
        public String toString() {
            return "Genre" +'\n'  +'\n'  +
                    "id=" + id +'\n'  +'\n'  +
                    "name= " + name + '\n' +'\n'+'\n'   ;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "MovieDetails"+ '\n'  +'\n'  +
                "adult=" + adult +'\n'  +'\n'  +
                "backdrop_path= " + backdrop_path + '\n' +'\n'  +
                "belongs_to_collection=" + belongs_to_collection +'\n'  +'\n'  +
                "budget=" + budget +'\n'  +'\n'  +
                "genres=" + genres +'\n'  +'\n'  +
                "homepage= " + homepage + '\n' +'\n'  +
                "id=" + id +'\n'  +'\n'  +
                "imdb_id= " + imdb_id + '\n' +'\n'  +
                "original_language= " + original_language + '\n' +'\n'  +
                "original_title= " + original_title + '\n' +'\n'  +
                "overview= " + overview + '\n' +'\n'  +
                "popularity=" + popularity + '\n'  +'\n'  +
                "poster_path= " + poster_path + '\n' +'\n'  +
                "production_companies=" + production_companies + '\n'  +'\n'  +
                "production_countries=" + production_countries +'\n'  +'\n'  +
                "release_date= " + release_date + '\n' +'\n'  +
                "revenue=" + revenue +'\n'  +'\n'  +
                "runtime=" + runtime +'\n'  +'\n'  +
                "spoken_languages=" + spoken_languages +'\n'  +'\n'  +
                "status= " + status + '\n' +'\n'  +
                "tagline= " + tagline + '\n' +'\n'  +
                "title= " + title + '\n' +'\n'  +
                "video=" + video +'\n'  +'\n'  +
                "vote_average=" + vote_average +'\n'  +'\n'  +
                "vote_count=" + vote_count +'\n'  +'\n'+'\n'  ;
    }
}

