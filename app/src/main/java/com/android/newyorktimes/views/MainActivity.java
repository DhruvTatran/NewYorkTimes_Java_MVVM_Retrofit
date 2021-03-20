package com.android.newyorktimes.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.newyorktimes.R;
import com.android.newyorktimes.adapters.MainActivityAdapter;
import com.android.newyorktimes.models.Article;
import com.android.newyorktimes.utils.ShowMessage;
import com.android.newyorktimes.viewmodels.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityAdapter.OnArticleClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainActivityAdapter mainActivityAdapter;
    private MainActivityViewModel mainActivityViewModel;
    ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.init();

        mainActivityViewModel.getArticles().observe(this, new Observer<ArrayList<Article>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Article> list) {
                articles.clear();
                articles.addAll(list);
                mainActivityAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        });

        initRecyclerView();
    }

    public void initRecyclerView() {
        mainActivityAdapter = new MainActivityAdapter(articles, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainActivityAdapter);
    }

    @Override
    public void onArticleClick(int position) {
        ShowMessage.showDialog(
                this,
                getResources().getString(R.string.dialog_title_details),
                articles.get(position).get_abstract(), getResources().getString(R.string.dialog_btn_dismiss),
                false);
    }
}
