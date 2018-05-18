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
import com.posakya.roshan.rxjava2.modal.Results;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by lokesh on 5/17/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    List<Results> newsModalClasses;
    Context context;

    public RecyclerViewAdapter(List<Results> newsModalClasses, Context context) {
        this.newsModalClasses = newsModalClasses;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.MyViewHolder holder, int position) {

        Results newsModalClass = newsModalClasses.get(position);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        long time = 0;
        try {
            time = sdf.parse(newsModalClass.getNewsdate()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long now = System.currentTimeMillis();

        CharSequence ago =
                DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);

        System.out.println("Date "+ago);

        holder.txt_news_title.setText(Html.fromHtml(newsModalClass.getTitle()));
        holder.txt_news_desc.setText(Html.fromHtml(newsModalClass.getDescription()));
        holder.txt_news_date.setText(ago);

        Glide.with(context)
                .load(newsModalClass.getImage()).listener(new RequestListener<String, GlideDrawable>() {
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
        }).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.news_image);

    }

    @Override
    public int getItemCount() {
        return newsModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txt_news_title,txt_news_date,txt_news_desc;
        private ImageView news_image;
        ProgressBar progressBar;

         MyViewHolder(View itemView) {
            super(itemView);

            txt_news_date = itemView.findViewById(R.id.news_date);
            txt_news_desc = itemView.findViewById(R.id.news_desc);
            txt_news_title = itemView.findViewById(R.id.news_title);
            news_image = itemView.findViewById(R.id.news_image);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
