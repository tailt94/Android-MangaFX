package com.tuantai0625.mangafx.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lionheart on 29-May-17.
 */

public class ChapterPages {
    @SerializedName("images")
    private List<ChapterPage> pages;

    public List<ChapterPage> getPages() {
        return pages;
    }

    public int getPageCOunt() {
        return pages.size();
    }

    private class ChapterPage extends ArrayList<Object> {
        private ChapterPage(int initialCapacity) {
            super(initialCapacity);
        }

        public ChapterPage() {
            this(4);
        }

        public int getPageNumber() {
            return (Integer) this.get(0);
        }

        public String getUrl() {
            return (String) this.get(1);
        }

        public int getWidth() {
            return (Integer) this.get(2);
        }

        public int getHeight() {
            return (Integer) this.get(3);
        }
    }
}
