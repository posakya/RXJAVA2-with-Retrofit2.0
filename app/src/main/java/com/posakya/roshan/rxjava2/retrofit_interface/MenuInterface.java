package com.posakya.roshan.rxjava2.retrofit_interface;

import com.posakya.roshan.rxjava2.modal.MenuClass;
import com.posakya.roshan.rxjava2.modal.NewsModal;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lokesh on 5/20/18.
 */

public interface MenuInterface {
    @GET("api1.php")
    Observable<List<MenuClass>> getMenu();
}
