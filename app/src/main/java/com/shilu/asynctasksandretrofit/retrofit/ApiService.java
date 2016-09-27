package com.shilu.asynctasksandretrofit.retrofit;

import com.shilu.asynctasksandretrofit.retrofit.models.Movies;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * this service defines the endpoints for our api call and also the type of request GET or POST
 */

public interface ApiService {

    /**
     * the type of the request like POST, GET, PUT, etc.. and the uri because in Retrofit you have
     * to set a base url (common url for all requests) and each method in your interface specifies
     * the end of your url with your arguments.
     */
    @GET("7dd655563327210f81b59eec983f82ee/raw/e413eea653a3797c618493930bbd8882268f2f4f/Retrofit%2520Training")
    Call<List<Movies>> getMovieListing();

}
