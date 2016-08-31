package com.muffin.thefmusic.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class itemOffsetDecoration extends RecyclerView.ItemDecoration {

    //La medida en pixeles del espacio
    private int mItemOffset;

    public itemOffsetDecoration(Context context, @IntegerRes int integerResId) {
        int itemOffSetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPx(itemOffSetDp, context.getResources().getDisplayMetrics());
    }

    public int convertToPx (int offsetDp, DisplayMetrics metrics) {
        return offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);

        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);

    }
}

