package com.shilu.asynctasksandretrofit.retrofit.models;

import com.google.gson.annotations.SerializedName;

/**
 * POJO for JSON parsing
 */

public class Movies {

    @SerializedName("Title")
    String movieName;

    @SerializedName("Year")
    String yearReleased;

    @SerializedName("Rated")
    String rated;

    @SerializedName("Released")
    String dateReleased;

    @SerializedName("Runtime")
    String runTime;

    @SerializedName("Genre")
    String genre;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
