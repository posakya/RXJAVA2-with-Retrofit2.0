package com.posakya.roshan.rxjava2.retrofit_interface;



import com.posakya.roshan.rxjava2.modal.NewsModal;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by lokesh on 5/17/18.
 */

public interface NewsInterface
{
    @GET("news")
    Observable<NewsModal> getNews();
}
