/**
 * 1. Create an application to use the Flickr api.
 *
 * You can use the following endpoint to get the images
 * http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1
 *
 * 2. Screen 1: Should show a recycler view with all the images from the api.
 * Each ItemView should have a thumbnail of the image and two more fields.
 *
 * 3. On Clicking long press on each item a dialog box with two options will appear.
 * “Show full image” and “Show small image”. You can add options to the array in an xml and pass to the dialog.
 * https://developer.android.com/guide/topics/ui/dialogs.html#AddingAList
 *
 * 4. “Show full image” will start a new activity and cover the whole screen with the passed picture.
 *
 * 5. “Show small image” will show the image in a dialog in the same activity.
 */

package com.example.week4day2_flickr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.week4day2_flickr.model.FlickrResponse;
import com.example.week4day2_flickr.model.RetrofitFlickr;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitFlickr retrofitFlickr = new RetrofitFlickr();
        retrofitFlickr.getService().getFlickrResponse("https://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1")
                .enqueue(new Callback<FlickrResponse>() {
                    @Override
                    public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {
                        FlickrResponse flickrResponse = response.body();
                        Log.d("TAG", flickrResponse.getTitle());
                    }

                    @Override
                    public void onFailure(Call<FlickrResponse> call, Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());
                    }
                });
    } // end onCreate
}
