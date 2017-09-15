package ru.hh.headhunterclient.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by neox on 14.09.17.
 */

public class LoadMoreListener extends RecyclerView.OnScrollListener {

    private OnLoadMoreListener mOnLoadMoreListener;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mIsLoading;
    private boolean mDone;
    private int mLastVisibleItem;

    public LoadMoreListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        super.onScrolled(recyclerView, dx, dy);

        if (dy <= 0) {
            return;
        }

        int totalItemCount = mLayoutManager.getItemCount();

        if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) mLayoutManager).findLastVisibleItemPositions(null);
            mLastVisibleItem = getLastVisibleItem(lastVisibleItemPositions);
        } else if (mLayoutManager instanceof GridLayoutManager) {
            mLastVisibleItem = ((GridLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        } else if (mLayoutManager instanceof LinearLayoutManager) {
            mLastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        }

        if (totalItemCount - 3 == mLastVisibleItem) {
            mIsLoading = false;
        }

        if (!mDone && !mIsLoading && totalItemCount <= (mLastVisibleItem + 1) && mOnLoadMoreListener != null) {
            mOnLoadMoreListener.onLoadMore();
            mIsLoading = true;
        }
    }

    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    public void refresh() {
        mIsLoading = false;
        mDone = false;
    }

    public void setDone(boolean done) {
        this.mDone = done;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
