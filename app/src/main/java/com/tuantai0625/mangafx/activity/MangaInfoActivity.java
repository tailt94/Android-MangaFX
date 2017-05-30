package com.tuantai0625.mangafx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.adapter.MangaChapterListAdapter;
import com.tuantai0625.mangafx.adapter.MangaListAdapter;
import com.tuantai0625.mangafx.model.MangaInfo;


public class MangaInfoActivity extends AppCompatActivity {
    private RecyclerView rvChapterList;
    private MangaChapterListAdapter adapter;
    private MangaInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_info);
        bindViews();

        info = (MangaInfo) getIntent()
                .getExtras()
                .getSerializable(MangaListAdapter.EXTRA_MANGA);

        showMangaChapterList(info);
    }

    private void bindViews() {
        rvChapterList = (RecyclerView) findViewById(R.id.rv_manga_chapters);
    }

    private void showMangaChapterList(MangaInfo info) {
        adapter = new MangaChapterListAdapter(this, info.getChapters());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvChapterList.setAdapter(adapter);
        rvChapterList.setLayoutManager(layoutManager);
        rvChapterList.setHasFixedSize(true);
    }
}
