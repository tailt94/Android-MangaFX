package com.tuantai0625.mangafx.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.adapter.ChapterPagesAdapter;
import com.tuantai0625.mangafx.adapter.MangaChapterListAdapter;
import com.tuantai0625.mangafx.model.ChapterPages;

import java.util.List;

public class MangaViewerActivity extends AppCompatActivity {
    private ChapterPages chapterPages;
    private List<List> pages;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_viewer);
        bindViews();

        chapterPages = (ChapterPages) getIntent()
                .getExtras()
                .getSerializable(MangaChapterListAdapter.EXTRA_MAGA_PAGES);

        pages = chapterPages.getPages();

        showChapterPages(pages);
    }

    private void bindViews() {
        viewPager = (ViewPager) findViewById(R.id.pager);
    }

    private void showChapterPages(List<List> pages) {
        ChapterPagesAdapter adapter = new ChapterPagesAdapter(this, pages);
        viewPager.setAdapter(adapter);
    }
}
