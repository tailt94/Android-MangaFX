package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.SerializedName;
import com.tuantai0625.mangafx.util.DateUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lionheart on 29-May-17.
 */

public class MangaInfo implements Serializable {
    @SerializedName("title")
    private String title;

    @SerializedName("alias")
    private String alias;

    @SerializedName("imageURL")
    private String imageUrl;

    @SerializedName("hits")
    private int views;

    @SerializedName("artist")
    private String artist;

    @SerializedName("author")
    private String author;

    @SerializedName("categories")
    private List<String> categories;

    @SerializedName("released")
    private int releasedYear;

    @SerializedName("description")
    private String description;

    @SerializedName("last_chapter_date")
    private long lastChapterDate;

    @SerializedName("chapters_len")
    private int chapterCount;

    @SerializedName("chapters")
    private List<List> chapters;

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getViews() {
        return views;
    }

    public String getArtist() {
        return artist;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getCategories() {
        return categories;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public String getDescription() {
        return description;
    }

    public String getLastChapterDate() {
        return DateUtils.getDate(lastChapterDate);
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public List<List> getChapters() {
        return chapters;
    }

}
