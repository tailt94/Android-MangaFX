package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lionheart on 26-May-17.
 */

public class MangaList {
    @SerializedName("manga")
    private List<Manga> mangaList = null;

    @SerializedName("total")
    private Integer mangaCount;

    public List<Manga> getMangaList() {
        return mangaList;
    }

    public Integer getMangaCount() {
        return mangaCount;
    }
}
