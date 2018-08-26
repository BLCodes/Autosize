
package com.tang.autodensity;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;

/**
 * ================================================
 * 屏幕适配逻辑策略类, 可通过 {@link DensityConfig#init(Application, boolean, AutoAdaptStrategy)}
 * 和 {@link DensityConfig#setAutoAdaptStrategy(AutoAdaptStrategy)} 切换策略
 *
 * @see DefaultAutoAdaptStrategy
 * ================================================
 */
public interface AutoAdaptStrategy {

    /**
     * 开始执行屏幕适配逻辑
     *
     * @param target   需要屏幕适配的对象 (可能是 {@link Activity} 或者 {@link Fragment})
     * @param activity 需要拿到当前的 {@link Activity} 才能修改 {@link DisplayMetrics#density}
     */
    void applyAdapt(Object target, Activity activity);
}
