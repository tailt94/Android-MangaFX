package com.tuantai0625.mangafx.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lionheart on 26-May-17.
 */

public class MangaListAdapter extends RecyclerView.Adapter<MangaListAdapter.MangaItemViewHolder> {
    public class MangaItemViewHolder extends RecyclerView.ViewHolder {
        public MangaItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public MangaItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MangaItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
