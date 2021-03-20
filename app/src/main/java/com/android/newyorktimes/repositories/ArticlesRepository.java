package com.android.newyorktimes.repositories;

import androidx.lifecycle.MutableLiveData;

import com.android.newyorktimes.models.Article;
import com.android.newyorktimes.models.Articles;
import com.android.newyorktimes.network.NetworkCall;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
* Singleton Pattern
* */
public class ArticlesRepository {

    private static ArticlesRepository instance;

    private ArticlesRepository() {}

    public static ArticlesRepository getInstance() {
        if(instance == null)
            instance = new ArticlesRepository();

        return instance;
    }

    public MutableLiveData<ArrayList<Article>> fetchArticles() {

        final MutableLiveData<ArrayList<Article>> data = new MutableLiveData<>();

        NetworkCall.getInstance().getService().getData().enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                if(response.isSuccessful()) {
                    data.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
