package com.tuantai0625.mangafx.service;

import com.tuantai0625.mangafx.model.MangaList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lionheart on 26-May-17.
 */

public interface MangaClient {
    @GET("list/0/")
    Call<MangaList> getMangaList();
}
