package com.tuantai0625.mangafx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.adapter.MangaListAdapter;
import com.tuantai0625.mangafx.model.MangaList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MangaListAdapter mangaListAdapter;
    private MangaList mangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        mangas = (MangaList) getIntent()
                .getExtras()
                .getSerializable(SplashActivity.EXTRA_MANGA_LIST);

        showMangaList(mangas);
    }

    private void bindViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_manga_list);
    }

    private void showMangaList(MangaList mangas) {
        mangaListAdapter = new MangaListAdapter(mangas.getMangaList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mangaListAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }
}
