package com.example.movies.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVItemDecoration(val spaceInPixels: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = spaceInPixels
        outRect.bottom = spaceInPixels
        outRect.right = spaceInPixels
        outRect.left = spaceInPixels
    }
}