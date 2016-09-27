package com.shilu.asynctasksandretrofit.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.shilu.asynctasksandretrofit.R;
import com.shilu.asynctasksandretrofit.retrofit.models.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    TextView tvResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_activity);

        tvResponse = (TextView) findViewById(R.id.tv_response);
    }

    public void startRetrofitRequest(View view) {

        /**
         * Retrofit callbacks are just sequence of instructions that needs to execute when the call is complete
         * the callback as we can see below has two methods on response and onfailure
         * on response is for success case. ie when the network call finishes and if the call was success, this method is called
         * if the network call is complete but there was some error, on failure is called
         *
         * what we are doing here is telling retrofit to start this particular api call and and passing
         * it callback to know what to do when the call completes'
         */
        RetrofitManager.getInstance().getMovieListing(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {
                Log.e("OnSuccess", "OnSuccess");
                tvResponse.setText("");
                for (Movies movies : response.body()) {
                    tvResponse.append("Movie : " + movies.getMovieName() + "\n");
                    tvResponse.append("Released on : " + movies.getDateReleased() + "\n");
                    tvResponse.append("Genre : " + movies.getGenre() + "\n");
                    tvResponse.append("\n" + "=====================" + "\n");
                }

            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {
                Log.e("OnFailure", "OnFailure " + t.getMessage());
            }
        });
    }
}
