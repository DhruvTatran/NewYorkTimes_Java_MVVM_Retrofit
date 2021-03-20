package com.android.newyorktimes.models;

import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String _abstract;
    @SerializedName("byline")
    private String byline;
    @SerializedName("published_date")
    private String published_date;

    public String getTitle() {
        return title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public String getByline() {
        return byline;
    }

    public String getPublished_date() {
        return published_date;
    }
}
