package com.example.mandeep.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MANDEEP on 6/11/2017.
 */

public class AdapterCardTag extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String[] items = {"#item1","#item2","#item3","#item4","#item5"};

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tagname;

        public ViewHolder(View itemView) {
            super(itemView);
            tagname = (TextView) itemView.findViewById(R.id.tagname);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.tagname.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
