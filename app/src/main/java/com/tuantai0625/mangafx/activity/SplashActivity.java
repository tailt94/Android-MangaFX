package com.tuantai0625.mangafx.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.model.MangaList;
import com.tuantai0625.mangafx.service.MangaClient;
import com.tuantai0625.mangafx.service.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    static final String EXTRA_MANGA_LIST = "EXTRA_MANGA_LIST";
    private MangaList mangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MangaClient client = ServiceGenerator.createService(MangaClient.class);
        Call<MangaList> call = client.getMangaList();

        call.enqueue(new Callback<MangaList>() {
            @Override
            public void onResponse(Call<MangaList> call, Response<MangaList> response) {
                if(response.isSuccessful()) {
                    mangas = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(EXTRA_MANGA_LIST, mangas);

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    finish();
                } else {
                    int statusCode = response.code();
                    Log.e(TAG, Integer.toString(statusCode));
                }
            }

            @Override
            public void onFailure(Call<MangaList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
