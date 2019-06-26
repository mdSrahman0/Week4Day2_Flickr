package com.example.week4day2_flickr.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RetrofitFlickr {

    public static final String BASE_URL = "https://api.flickr.com/";
    //public static final String PATH = "services/feeds/photos_public.gne";

    public Retrofit getRetrofitInstance() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    } // end method

    public getFlickrService getService(){
        return getRetrofitInstance().create(getFlickrService.class);
    }

    public interface getFlickrService {
        @GET
        Call<FlickrResponse> getFlickrResponse(@Url String s);
    }

}
