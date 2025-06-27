package com.lsposed.translator;

import android.widget.TextView;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Main implements IXposedHookLoadPackage {
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("app.revanced.youtube")) return;

        findAndHookMethod(TextView.class, "setText", CharSequence.class, TextView.BufferType.class, boolean.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                CharSequence original = (CharSequence) param.args[0];
                if (original != null && original.length() > 2 && original.length() < 200 && !original.toString().contains("🇮🇷")) {
                    try {
                        String translated = TranslateUtils.translate(original.toString());
                        param.args[0] = translated;
                    } catch (Exception ignored) {
                    }
                }
            }
        });
    }
}