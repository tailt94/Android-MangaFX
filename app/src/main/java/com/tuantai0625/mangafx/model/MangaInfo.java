package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.tuantai0625.mangafx.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lionheart on 29-May-17.
 */

public class MangaInfo {
    @SerializedName("title")
    public String title;

    @SerializedName("alias")
    public String alias;

    @SerializedName("imageURL")
    public String imageUrl;

    @SerializedName("hits")
    public Integer views;

    @SerializedName("artist")
    public String artist;

    @SerializedName("author")
    public String author;

    @SerializedName("categories")
    public List<String> categories = null;

    @SerializedName("released")
    public Integer released;

    @SerializedName("description")
    public String description;

    @SerializedName("last_chapter_date")
    public Integer lastChapterDate;

    @SerializedName("chapters_len")
    public int chapterCount;

    @SerializedName("chapters")
    public List<Chapter> chapters = null;

    private class Chapter extends ArrayList<Object> {
        private Chapter(int initialCapacity) {
            super(initialCapacity);
        }

        public Chapter() {
            this(4);
        }

        public float getChapterNumber() {
            return (Float) get(0);
        }

        public String getDate() {
            return DateUtils.getDate((Long) get(1));
        }

        public String getTitle() {
            return (String) get(2);
        }

        public String getId() {
            return (String) get(3);
        }
    }
}
