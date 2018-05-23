package com.posakya.roshan.rxjava2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.posakya.roshan.rxjava2.adapter.MenuAdapter;
import com.posakya.roshan.rxjava2.modal.MenuClass;

import com.posakya.roshan.rxjava2.retrofit_interface.MenuInterface;
import com.posakya.roshan.rxjava2.retrofit_response.MenuResponse;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MenuClass> list;
    AVLoadingIndicatorView avi;
    MenuAdapter menuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        avi = findViewById(R.id.avi);

        recyclerView = findViewById(R.id.recyclerView);

        getMenuJson("Bakery Items");
    }

    public void getMenuJson(String Menu_Type){

        MenuInterface menuInterface = MenuResponse.getMenuResponse().create(MenuInterface.class);

        Observable<List<MenuClass>> observable = menuInterface.getMenu(Menu_Type).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        avi.show();

        observable.subscribe(new Observer<List<MenuClass>>() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println("subscribe");

            }

            @Override
            public void onNext(List<MenuClass> menuClasses) {

                System.out.println("NEXt");

                list = new ArrayList<>();

                for (int i=0; i<menuClasses.size(); i++){

                    MenuClass menuClass = new MenuClass();

                    menuClass.setItem_Name(menuClasses.get(i).getItem_Name());
                    menuClass.setMenu_Type(menuClasses.get(i).getMenu_Type());
                    menuClass.setImage("http://192.168.2.1/zappfood/Image/"+menuClasses.get(i).getImage());

                    list.add(menuClass);

                }

                menuAdapter = new MenuAdapter(list,MenuActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(menuAdapter);
                menuAdapter.notifyDataSetChanged();

                avi.hide();

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error : "+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Complete");
            }
        });


    }
}
