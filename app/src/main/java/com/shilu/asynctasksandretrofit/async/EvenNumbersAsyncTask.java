package com.shilu.asynctasksandretrofit.async;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Loop for even numbers
 */
public class EvenNumbersAsyncTask extends AsyncTask<Integer, Integer, ArrayList<Integer>> {

    private static final String TAG = EvenNumbersAsyncTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "onPreExecute");
    }

    @Override
    protected ArrayList<Integer> doInBackground(Integer... params) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        int loopLimit = params[0];

        for (int i = 0; i < loopLimit; i++) {
            if (i % 2 == 0) {
                evenNumbers.add(i);

                /**
                 *if this was a download task, we would have actual numbers to measure progress
                 * but since this is just a loop, we will be sending progress after 1000 increment
                 */
                if (i % 1000 == 0) {
                    publishProgress(i);
                }
            }

            for (int j = 0; j < 100; j++) ;
        }

        return evenNumbers;
    }

    @Override
    protected void onPostExecute(ArrayList<Integer> integers) {
        super.onPostExecute(integers);
        Log.e(TAG, "onPostExecute");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.e(TAG, "onProgressUpdate " + values[0]);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.e(TAG, "onCancelled");
    }
}
