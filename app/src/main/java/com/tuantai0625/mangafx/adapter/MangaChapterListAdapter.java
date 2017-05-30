package com.tuantai0625.mangafx.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.activity.MangaViewerActivity;
import com.tuantai0625.mangafx.model.ChapterPages;
import com.tuantai0625.mangafx.service.MangaClient;
import com.tuantai0625.mangafx.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lionheart on 29-May-17.
 */

public class MangaChapterListAdapter extends RecyclerView.Adapter<MangaChapterListAdapter.MangaChapterViewHolder> {
    public static final String EXTRA_MAGA_PAGES = "EXTRA_MAGA_PAGES";
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
            itemView.setOnClickListener(new MangaChapterClickListener());
        }

        private class MangaChapterClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                String id = (String) chapters.get(pos).get(3);

                MangaClient client = ServiceGenerator.createService(MangaClient.class);
                Call<ChapterPages> call = client.getChapterPages(id);
                call.enqueue(new Callback<ChapterPages>() {
                    @Override
                    public void onResponse(Call<ChapterPages> call, Response<ChapterPages> response) {
                        if (response.isSuccessful()) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(EXTRA_MAGA_PAGES, response.body());
                            Intent intent = new Intent(context, MangaViewerActivity.class);
                            intent.putExtras(bundle);
                            context.startActivity(intent);
                        } else {
                            int statusCode = response.code();
                            Log.e("MangaChapterListAdapter", Integer.toString(statusCode));
                        }
                    }

                    @Override
                    public void onFailure(Call<ChapterPages> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        }
    }
}
