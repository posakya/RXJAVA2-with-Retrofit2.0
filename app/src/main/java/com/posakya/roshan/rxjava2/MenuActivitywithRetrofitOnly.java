package com.posakya.roshan.rxjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.posakya.roshan.rxjava2.adapter.MenuAdapter;
import com.posakya.roshan.rxjava2.modal.MenuClass;
import com.posakya.roshan.rxjava2.retrofit_interface.MenuInterfaceWithRetrofitOnly;
import com.posakya.roshan.rxjava2.retrofit_response.MenuResponseWithRetrofitOnly;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivitywithRetrofitOnly extends AppCompatActivity {
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

        avi.show();

        getMenuJson("Bakery Items");
    }

    public void getMenuJson(String Menu_type){

        MenuInterfaceWithRetrofitOnly menuInterfaceWithRetrofitOnly = MenuResponseWithRetrofitOnly.getMenuResponse().create(MenuInterfaceWithRetrofitOnly.class);

        Call<List<MenuClass>> menuList = menuInterfaceWithRetrofitOnly.getMenu(Menu_type);

        menuList.enqueue(new Callback<List<MenuClass>>() {
            @Override
            public void onResponse(Call<List<MenuClass>> call, Response<List<MenuClass>> response) {
                list = response.body();

                System.out.println("Response "+response.body());

                menuAdapter = new MenuAdapter(list,MenuActivitywithRetrofitOnly.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuActivitywithRetrofitOnly.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(menuAdapter);
                menuAdapter.notifyDataSetChanged();

                avi.hide();
            }

            @Override
            public void onFailure(Call<List<MenuClass>> call, Throwable t) {
                System.out.println("Error "+t.getMessage());
            }
        });

    }
}
