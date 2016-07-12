package com.example.lcy.nbanews.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-11.
 */
public class BaseApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Logger.init();
    }
}
