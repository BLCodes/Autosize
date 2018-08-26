package com.tang.autosize;

import android.app.Activity;
import android.app.Application;

import com.tang.autodensity.DensityConfig;
import com.tang.autodensity.external.ExternalAdapterManager;
import com.tang.autodensity.internal.CustomAdapter;

public class XxxxApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DensityConfig.getInstance()
//                .setCustomFragment(true)
//                .setUseDeviceSize(true)
//                .setBaseOnWidth(false)
//                .setAutoAdaptStrategy(new AutoAdaptStrategy())
        ;
        customAdapterForExternal();
    }

    /**
     * 给外部的三方库 {@link Activity} 自定义适配参数, 因为三方库的 {@link Activity} 并不能通过实现
     * {@link CustomAdapter} 接口的方式来提供自定义适配参数 (因为远程依赖改不了源码)
     * 所以使用 {@link ExternalAdapterManager} 来替代实现接口的方式, 来提供自定义适配参数
     */
    private void customAdapterForExternal() {
//        DensityConfig.getInstance().getExternalAdaptManager()
//                .addExternalAdaptInfoOfActivity(DefaultErrorActivity.class, new ExternalAdapterInfo(true, 400));
    }
}
