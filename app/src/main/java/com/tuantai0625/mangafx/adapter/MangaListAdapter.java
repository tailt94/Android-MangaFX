package com.tuantai0625.mangafx.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tuantai0625.mangafx.R;
import com.tuantai0625.mangafx.activity.MangaInfoActivity;
import com.tuantai0625.mangafx.model.Manga;
import com.tuantai0625.mangafx.model.MangaInfo;
import com.tuantai0625.mangafx.service.MangaClient;
import com.tuantai0625.mangafx.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lionheart on 26-May-17.
 */

public class MangaListAdapter extends RecyclerView.Adapter<MangaListAdapter.MangaItemViewHolder> {
    public static final String EXTRA_MANGA = "EXTRA_MANGA";
    private Context context;
    private List<Manga> mangaList;

    public MangaListAdapter(Context context, List<Manga> mangaList) {
        this.context = context;
        this.mangaList = mangaList;
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
        holder.tvViews.setText(Integer.toString(mangaList.get(position).getViews()));
        holder.tvLastChapterDate.setText(mangaList.get(position).getLastChapterDate());
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public void updateMangaList(List<Manga> list) {
        mangaList = list;
        notifyDataSetChanged();
    }

    public class MangaItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvViews;
        TextView tvLastChapterDate;

        public MangaItemViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.text_manga_name);
            tvViews = (TextView) itemView.findViewById(R.id.text_manga_views);
            tvLastChapterDate = (TextView) itemView.findViewById(R.id.text_manga_last_chapter_date);

            itemView.setOnClickListener(new MangaItemClickListener());
        }

        private class MangaItemClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                String id = mangaList.get(pos).getId();

                MangaClient client = ServiceGenerator.createService(MangaClient.class);
                Call<MangaInfo> call = client.getMangaInfo(id);
                call.enqueue(new Callback<MangaInfo>() {
                    @Override
                    public void onResponse(Call<MangaInfo> call, Response<MangaInfo> response) {
                        if (response.isSuccessful()) {
                            MangaInfo mangaInfo = response.body();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(EXTRA_MANGA, mangaInfo);
                            Intent intent = new Intent(context, MangaInfoActivity.class);
                            intent.putExtras(bundle);
                            context.startActivity(intent);
                        } else {
                            int statusCode = response.code();
                            Log.e("MangaListAdapter", Integer.toString(statusCode));
                        }
                    }

                    @Override
                    public void onFailure(Call<MangaInfo> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        }
    }
}
