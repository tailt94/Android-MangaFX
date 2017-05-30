package com.tuantai0625.mangafx.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lionheart on 29-May-17.
 */

public class ChapterPages implements Serializable {
    @SerializedName("images")
    private List<List> pages;

    public List<List> getPages() {
        return pages;
    }

    public int getPageCount() {
        return pages.size();
    }
}
