package com.example.myapplication.utils;

import android.app.Application;
import android.util.Log;
import org.xutils.x;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        Log.d("content","application onCreate()...");

        //x是utils里的类，Ext是静态方法，可以通过类直接调用,实现了xutils3框架的初始化
        x.Ext.init(this);
        super.onCreate();
    }
}
