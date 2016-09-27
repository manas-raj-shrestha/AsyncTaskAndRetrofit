package com.shilu.asynctasksandretrofit.async;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shilu.asynctasksandretrofit.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * change in Manifest for retrofit activity
 * this is just for async
 */
public class AsyncActivity extends AppCompatActivity {

    AsyncTask<Integer, Integer, ArrayList<Integer>> evenNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAsyncTask(View view) {
        evenNumbers = new EvenNumbersAsyncTask().execute(10000000);
    }

    /**
     * get() makes asynchronous task synchronous
     * this means we have to wait for doInBackground to complete
     * So, the UI freezes up
     * Notice the freeze in ripple and button press state
     */
    public void startAsyncTaskWithGet(View view) {
        try {
            new EvenNumbersAsyncTask().execute(10000000).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * the cancel may be called seconds later you press the cancel button
     * this is because the logging is much slower than the action processing
     * thread has already told the logger to log the progress but logging it out in the log cat takes time
     */
    public void cancelAsyncTask(View view) {
        evenNumbers.cancel(true);
    }
}
