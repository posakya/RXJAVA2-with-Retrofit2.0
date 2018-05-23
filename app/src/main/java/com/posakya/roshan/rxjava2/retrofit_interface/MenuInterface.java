package com.posakya.roshan.rxjava2.retrofit_interface;

import com.posakya.roshan.rxjava2.modal.MenuClass;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lokesh on 5/20/18.
 */

public interface MenuInterface {
    @GET("api.php")
    Observable<List<MenuClass>> getMenu(@Query("Menu_Type") String Menu_Type);
}
