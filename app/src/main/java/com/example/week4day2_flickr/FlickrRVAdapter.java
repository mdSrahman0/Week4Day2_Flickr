package com.example.week4day2_flickr;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4day2_flickr.model.FlickrResponse;
import com.example.week4day2_flickr.model.Item;

import java.util.List;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder>{

    List<Item> listOfItems;

    public FlickrRVAdapter(List<Item> items) {
        this.listOfItems = items;
    }
    @NonNull
    @Override
    public FlickrRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.flickr_rv_items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrRVAdapter.ViewHolder viewHolder, int i) {
        final Item itemFlickr = listOfItems.get(i);
        final String title = itemFlickr.getTitle();
        final String link = itemFlickr.getLink();
        final String imageURL = itemFlickr.getMedia().getM();
        viewHolder.tvTitle.setText(title);
        viewHolder.tvLink.setText(link);
        Glide.with(viewHolder.imgPic).load(imageURL).into(viewHolder.imgPic);
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
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
