package com.tuantai0625.mangafx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.adapter.MangaListAdapter;
import com.tuantai0625.mangafx.model.Manga;
import com.tuantai0625.mangafx.model.MangaList;
import com.tuantai0625.mangafx.service.MangaClient;
import com.tuantai0625.mangafx.service.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MangaListAdapter mangaListAdapter;
    private MangaClient client;
    private MangaList list = null;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_manga_list);
        mangaListAdapter = new MangaListAdapter(new ArrayList<Manga>(0));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mangaListAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        client = ServiceGenerator.createService(MangaClient.class);

        Call<MangaList> call = client.getMangaList();

        call.enqueue(new Callback<MangaList>() {
            @Override
            public void onResponse(Call<MangaList> call, Response<MangaList> response) {
                if(response.isSuccessful()) {
                    list = response.body();
                    mangaListAdapter.updateMangaList(list.getMangaList());
                } else {
                    int statusCode = response.code();
                    Log.e("Service", "FAILED");
                    Log.e("CODE", Integer.toString(statusCode));
                }
            }

            @Override
            public void onFailure(Call<MangaList> call, Throwable t) {
                Log.e("Service", "FAILED");
            }
        });


    }
}
