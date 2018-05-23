package com.posakya.roshan.rxjava2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.posakya.roshan.rxjava2.R;
import com.posakya.roshan.rxjava2.modal.MenuClass;
import com.posakya.roshan.rxjava2.modal.Results;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by lokesh on 5/20/18.
 */


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder>{

    List<MenuClass> menuClasses;
    Context context;

    public MenuAdapter(List<MenuClass> menuClasses, Context context) {
        this.menuClasses = menuClasses;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        MenuClass menuClass = menuClasses.get(position);


        holder.txt_menu_title.setText(Html.fromHtml(menuClass.getMenu_Type()));
        holder.txt_menu_desc.setText(Html.fromHtml(menuClass.getItem_Name()));

        System.out.println("MenuType : "+menuClass.getMenu_Type());

        Glide.with(context)
                .load(menuClass.getImage()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.menu_image);

    }

    @Override
    public int getItemCount() {
        return menuClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txt_menu_title,txt_menu_desc;
        private ImageView menu_image;
        ProgressBar progressBar;

        MyViewHolder(View itemView) {
            super(itemView);


            txt_menu_desc = itemView.findViewById(R.id.menu_desc);
            txt_menu_title = itemView.findViewById(R.id.menu_title);
            menu_image = itemView.findViewById(R.id.menu_image);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
