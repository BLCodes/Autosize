package com.tang.autodensity.utils;

import android.content.Context;
import android.util.TypedValue;

public class DensityUtil {
    private DensityUtil() {
        throw new IllegalStateException("instantiate disallowed!");
    }
    public static int dp2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }
}
