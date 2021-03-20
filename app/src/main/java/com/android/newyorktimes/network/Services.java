package com.android.newyorktimes.network;

import com.android.newyorktimes.models.Articles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {
    @GET(NetworkConstants.END_POINTS)
    Call<Articles> getData();
}
