package com.posakya.roshan.rxjava2.retrofit_response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lokesh on 5/23/18.
 */

public class MenuResponseWithRetrofitOnly {
    public static Retrofit retrofit = null;

    public static Retrofit getMenuResponse(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.2.1/zappfood/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
