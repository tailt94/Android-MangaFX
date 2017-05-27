package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Lionheart on 26-May-17.
 */

public class Manga implements Serializable {
    @SerializedName("t")
    private String title;
    @SerializedName("a")
    private String alias;
    @SerializedName("i")
    private String id;
    @SerializedName("im")
    private String image;
    @SerializedName("c")
    private List<String> categories;
    @SerializedName("h")
    private int views;
    @SerializedName("ld")
    private int lastChapterDate;
    @SerializedName("s")
    private int status;

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

    public String getLastChapterDate() {
        Date date = new Date(lastChapterDate * 1000L);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return format.format(date);
    }

    public Integer getStatus() {
        return status;
    }
}
