package com.example.week4day2_flickr;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder>{

    @NonNull
    @Override
    public FlickrRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrRVAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPic;
        TextView tvTitle;
        TextView tvLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPic = itemView.findViewById(R.id.imgPic);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvLink = itemView.findViewById(R.id.tvLink);
        }
    }
}
