package com.android.newyorktimes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.newyorktimes.R;
import com.android.newyorktimes.models.Article;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Article> arrayList;
    private OnArticleClickListener onArticleClickListener;

    public MainActivityAdapter(ArrayList<Article> arr, Context c, OnArticleClickListener onArticleClickListener) {
        this.arrayList = arr;
        this.context = c;
        this.onArticleClickListener = onArticleClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);

        return new MyViewHolder(itemView, onArticleClickListener);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.by_line.setText(arrayList.get(position).getByline());
        holder.date.setText(arrayList.get(position).getPublished_date());
    }

    @Override
    public int getItemCount() {
        return (arrayList == null ? 0 : arrayList.size());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, by_line, date;
        OnArticleClickListener onArticleClickListener;

        public MyViewHolder(View itemView, OnArticleClickListener onArticleClickListener) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            by_line = itemView.findViewById(R.id.by_line);
            date = itemView.findViewById(R.id.date);
            this.onArticleClickListener = onArticleClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onArticleClickListener.onArticleClick(getAdapterPosition());
        }
    }

    public interface OnArticleClickListener {
        void onArticleClick(int position);
    }
}
