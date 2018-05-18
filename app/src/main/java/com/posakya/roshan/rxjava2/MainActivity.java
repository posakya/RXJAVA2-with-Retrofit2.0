package com.posakya.roshan.rxjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.posakya.roshan.rxjava2.adapter.RecyclerViewAdapter;
import com.posakya.roshan.rxjava2.modal.NewsModal;
import com.posakya.roshan.rxjava2.modal.Results;
import com.posakya.roshan.rxjava2.retrofit_interface.NewsInterface;
import com.posakya.roshan.rxjava2.retrofit_response.NewsResponse;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Results> list;
    AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        avi = findViewById(R.id.avi);

        recyclerView = findViewById(R.id.recyclerView);



        getNewsJson();

    }

    public void getNewsJson(){

        NewsInterface newsInterface = NewsResponse.getNewsResponse().create(NewsInterface.class);


        Observable<NewsModal> observable = newsInterface.getNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        avi.show();


        observable.subscribe(new Observer<NewsModal>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewsModal newsModal) {

                list = new ArrayList<>();
                List<Results> results = newsModal.getResults();
                Log.d("size", String.valueOf(results.size()));

                for (int i=0; i<results.size(); i++){
                    Results results1 = new Results();
                    results1.setId(results.get(i).getId());
                    results1.setDescription(results.get(i).getDescription());
                    results1.setImage(results.get(i).getImage());
                    results1.setNewsdate(results.get(i).getNewsdate());
                    results1.setTitle(results.get(i).getTitle());
                    list.add(results1);
                }

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list,MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerViewAdapter.notifyDataSetChanged();

                avi.hide();
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("Error : "+e);

            }

            @Override
            public void onComplete() {

            }

        });


    }
}
