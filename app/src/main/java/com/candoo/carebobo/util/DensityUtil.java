package com.candoo.carebobo.util;

import android.content.Context;

public class DensityUtil {

    public static int pxFromDp(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int dpFromPx(Context context, float px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
