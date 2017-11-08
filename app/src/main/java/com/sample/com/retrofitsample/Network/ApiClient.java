package com.sample.com.retrofitsample.Network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.report.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 09/06/2017.
 */

public class ApiClient {
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient
                    .Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);
            httpClient.addInterceptor(loggingInterceptor);  // <-- this is the important line!
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
