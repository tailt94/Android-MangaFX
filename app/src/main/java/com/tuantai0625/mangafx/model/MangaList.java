package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lionheart on 26-May-17.
 */

public class MangaList implements Serializable {
    @SerializedName("manga")
    private List<Manga> mangaList;

    @SerializedName("total")
    private Integer mangaCount;

    public List<Manga> getMangaList() {
        return mangaList;
    }

    public Integer getMangaCount() {
        return mangaCount;
    }
}
