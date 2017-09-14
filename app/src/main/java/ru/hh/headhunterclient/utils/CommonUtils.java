package ru.hh.headhunterclient.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by neox on 13.09.17.
 */

public class CommonUtils {

    private Context mContext;

    public CommonUtils(Context context) {
        this.mContext = context;
    }

    public boolean isLarge() {
        return (mContext.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
                && mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

}
