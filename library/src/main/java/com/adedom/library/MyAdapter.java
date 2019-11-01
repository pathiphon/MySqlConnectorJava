package com.adedom.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private ArrayList<MyDataBean> items;

    public MyAdapter() {
    }

    public MyAdapter(ArrayList<MyDataBean> items) {
        this.items = new ArrayList<>();
        this.items = items;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        holder.textView.setText(items.get(i).getTextView());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void refresh(ArrayList<MyDataBean> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}