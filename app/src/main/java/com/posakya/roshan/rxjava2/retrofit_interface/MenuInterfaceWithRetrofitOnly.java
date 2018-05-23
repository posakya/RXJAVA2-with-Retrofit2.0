package com.posakya.roshan.rxjava2.retrofit_interface;

import com.posakya.roshan.rxjava2.modal.MenuClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lokesh on 5/23/18.
 */

public interface MenuInterfaceWithRetrofitOnly {
    @GET("api.php")
    Call<List<MenuClass>> getMenu(@Query("Menu_Type") String Menu_Type);
}
