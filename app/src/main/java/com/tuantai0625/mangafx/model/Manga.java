package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lionheart on 26-May-17.
 */

public class Manga {
    @SerializedName("t")
    public String title;
    @SerializedName("a")
    public String alias;
    @SerializedName("i")
    public String id;
    @SerializedName("im")
    public String image;
    @SerializedName("c")
    public List<String> categories = null;
    @SerializedName("h")
    public Integer views;
    @SerializedName("ld")
    public Integer lastChapterDate;
    @SerializedName("s")
    public Integer lastChapter;

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getLastChapterDate() {
        return lastChapterDate;
    }

    public Integer getLastChapter() {
        return lastChapter;
    }
}
