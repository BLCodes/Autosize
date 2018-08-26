
package com.tang.autodensity;

import android.app.Activity;
import android.app.Application;

import com.tang.autodensity.external.ExternalAdapterInfo;
import com.tang.autodensity.internal.CancelAdapter;
import com.tang.autodensity.internal.CustomAdapter;

/**
 * ================================================
 * 屏幕适配逻辑策略默认实现类, 可通过 {@link DensityConfig#init(Application, boolean, AutoAdaptStrategy)}
 * 和 {@link DensityConfig#setAutoAdaptStrategy(AutoAdaptStrategy)} 切换策略
 *
 * @see AutoAdaptStrategy
 * ================================================
 */
public class DefaultAutoAdaptStrategy implements AutoAdaptStrategy {
    @Override
    public void applyAdapt(Object target, Activity activity) {

        //检查是否开启了外部三方库的适配模式, 只要不主动调用 ExternalAdaptManager 的方法, 下面的代码就不会执行
        if (DensityConfig.getInstance().getExternalAdaptManager().isRun()) {
            if (DensityConfig.getInstance().getExternalAdaptManager().isCancelAdapt(target.getClass())) {
                AutoSize.cancelAdapt(activity);
                return;
            } else {
                ExternalAdapterInfo info = DensityConfig.getInstance().getExternalAdaptManager()
                        .getExternalAdaptInfoOfActivity(target.getClass());
                if (info != null) {
                    AutoSize.autoConvertDensityOfExternalAdaptInfo(activity, info);
                    return;
                }
            }
        }

        //如果 target 实现 CancelAdapt 接口表示放弃适配, 所有的适配效果都将失效
        if (target instanceof CancelAdapter) {
            AutoSize.cancelAdapt(activity);
            return;
        }

        //如果 target 实现 CustomAdapt 接口表示该 target 想自定义一些用于适配的参数, 从而改变最终的适配效果
        if (target instanceof CustomAdapter) {
            AutoSize.autoConvertDensityOfCustomAdapt(activity, (CustomAdapter) target);
        } else {
            AutoSize.autoConvertDensityOfGlobal(activity);
        }
    }
}
