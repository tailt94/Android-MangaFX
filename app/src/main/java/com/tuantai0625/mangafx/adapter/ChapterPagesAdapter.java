package com.tuantai0625.mangafx.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tuantai0625.mangafx.R;

import java.util.List;

/**
 * Created by Lionheart on 30-May-17.
 */

public class ChapterPagesAdapter extends PagerAdapter {
    private static final String IMAGE_BASE_URL = "http://cdn.mangaeden.com/mangasimg/";
    private Context context;
    private List<List> pages;

    public ChapterPagesAdapter(Context context, List<List> pages) {
        this.context = context;
        this.pages = pages;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        String imageUrl = IMAGE_BASE_URL + (String) pages.get(pages.size() - 1 - position).get(1);
        Picasso
                .with(context)
                .load(imageUrl)
                .placeholder(R.drawable.logo)
                .into(mImageView);
        container.addView(mImageView);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
