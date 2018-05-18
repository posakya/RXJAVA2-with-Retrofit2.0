package com.posakya.roshan.rxjava2.retrofit_response;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lokesh on 5/17/18.
 */

public class NewsResponse {

    public static Retrofit retrofit = null;

    public static Retrofit getNewsResponse(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://epssathi.com/api/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
