package com.example.mandeep.myapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by MANDEEP on 6/12/2017.
 */

public class AdapterCardDirectory extends RecyclerView.Adapter<AdapterCardDirectory.ViewHolder> {

    File[] list_items;

    public AdapterCardDirectory(File[] items) {
        list_items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public CardView card;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.directory_name);
            card = (CardView) v.findViewById(R.id.card_view_directory);
        }
    }
    @Override
    public AdapterCardDirectory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_directory, parent, false);
        return new AdapterCardDirectory.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTextView.setText(list_items[position].getName());

        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //TODO:save this as the selected directory
                //TODO: go to new page where each image file has options
                return false;
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if contains directories containing jpg then update else select
                update(holder.getAdapterPosition());
            }
        });
    }

    private void update(int position) {
        //TODO:put conditions and file selection code
        //TODO: check if inner directory exists
        //TODO: no hidden files
        File f = list_items[position];
        list_items = f.listFiles();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list_items.length;
    }
}
