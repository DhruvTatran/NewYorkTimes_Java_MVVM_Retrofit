package com.android.newyorktimes.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.newyorktimes.models.Article;
import com.android.newyorktimes.repositories.ArticlesRepository;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Article>> listArticles;

    public void init() {
        if (listArticles != null)
            return;
        else
            listArticles = ArticlesRepository.getInstance().fetchArticles();
    }

    public LiveData<ArrayList<Article>> getArticles() {
        return listArticles;
    }
}
