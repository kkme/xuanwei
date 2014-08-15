package com.weixuan.football.ui;

import android.app.Application;
import com.weixuan.football.entity.Token;

/**
 * Created by Hua on 2014/8/4.
 */
public class FootballApplication extends Application{
    private Token token;
    @Override
    public void onCreate() {
        super.onCreate();

    }



    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
