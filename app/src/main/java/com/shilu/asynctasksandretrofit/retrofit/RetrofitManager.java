package com.shilu.asynctasksandretrofit.retrofit;

import com.shilu.asynctasksandretrofit.retrofit.models.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit manager should a singleton class
 */
public class RetrofitManager {

    private static final String BASE_URL = "https://gist.githubusercontent.com/manas-raj-shrestha/";

    private static RetrofitManager retrofitManager;

    private Retrofit retrofit;
    private ApiService apiService;

    public static RetrofitManager getInstance() {
        if (retrofitManager == null)
            retrofitManager = new RetrofitManager();

        return retrofitManager;
    }

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    /**
     * callbacks and calls are not same
     * Calls are for making the network call, callbacks are instructions about what to do when the call completed
     * call.enqueue starts an asynchronous call
     * call.execute starts a synchronous call
     */
    public void getMovieListing(Callback<List<Movies>> moviesCallback) {
        Call<List<Movies>> moviesCall = apiService.getMovieListing();
        moviesCall.enqueue(moviesCallback);
    }

}
