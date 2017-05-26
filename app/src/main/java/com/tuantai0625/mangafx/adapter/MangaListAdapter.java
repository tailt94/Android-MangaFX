package com.tuantai0625.mangafx.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.model.Manga;

import java.util.List;

/**
 * Created by Lionheart on 26-May-17.
 */

public class MangaListAdapter extends RecyclerView.Adapter<MangaListAdapter.MangaItemViewHolder> {
    private List<Manga> mangaList;

    public MangaListAdapter(List<Manga> mangaList) {
        this.mangaList = mangaList;
    }

    public class MangaItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvViews;
        TextView tvLastChapter;

        public MangaItemViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_manga_name);
            tvViews = (TextView) itemView.findViewById(R.id.tv_manga_views);
            tvLastChapter = (TextView) itemView.findViewById(R.id.tv_manga_last_chapter);
        }
    }

    @Override
    public MangaItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_manga_list, parent, false);
        return new MangaItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MangaItemViewHolder holder, int position) {
        holder.tvName.setText(mangaList.get(position).getTitle());
        holder.tvViews.setText(mangaList.get(position).getViews().toString());
        holder.tvLastChapter.setText(mangaList.get(position).getLastChapter().toString());
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public void updateMangaList(List<Manga> list) {
        mangaList = list;
        notifyDataSetChanged();
    }
}
