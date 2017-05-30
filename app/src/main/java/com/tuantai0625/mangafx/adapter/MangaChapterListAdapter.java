package com.tuantai0625.mangafx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuantai0625.mangafx.R;

import java.util.List;

/**
 * Created by Lionheart on 29-May-17.
 */

public class MangaChapterListAdapter extends RecyclerView.Adapter<MangaChapterListAdapter.MangaChapterViewHolder> {
    private Context context;
    private List<List> chapters;

    public MangaChapterListAdapter(Context context, List<List> chapters) {
        this.context = context;
        this.chapters = chapters;
    }

    @Override
    public MangaChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_manga_chapter, parent, false);
        return new MangaChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MangaChapterViewHolder holder, int position) {
        holder.tvChapter.setText(Double.toString((Double) chapters.get(position).get(0)));
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public class MangaChapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tvChapter;
        public MangaChapterViewHolder(View itemView) {
            super(itemView);
            tvChapter = (TextView) itemView.findViewById(R.id.text_chapter);
        }
    }
}
