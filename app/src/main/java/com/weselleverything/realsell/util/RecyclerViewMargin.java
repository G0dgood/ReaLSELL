package com.weselleverything.realsell.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewMargin extends RecyclerView.ItemDecoration{

    private final int columns;
    private final int margin;

    public RecyclerViewMargin(int columns, int margin) {
        this.columns = columns;
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        outRect.right = margin;
        outRect.bottom = margin;

        if(position < columns){
            outRect.top = margin;
        }

        if(position % columns == 0) {
            outRect.left = margin;
        }
    }
}
