package com.app.lizzymendivil.retrofittest.WebServices;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public class RetrofitClient {

    public static APIService API_SERVICE;

    public static APIService getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(httpLoggingInterceptor);

        String baseURL = "https://jsonplaceholder.typicode.com";

        if (API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseURL)
                    .build();
            API_SERVICE = retrofit.create(APIService.class);
        }

        return API_SERVICE;
    }
}
