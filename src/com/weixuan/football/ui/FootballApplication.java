package com.weixuan.football.ui;

import android.app.Application;
import com.weixuan.football.data.RequestManager;

/**
 * Created by Hua on 2014/8/4.
 */
public class FootballApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        RequestManager.init(this);
    }
}
