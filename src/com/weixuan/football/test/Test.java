package com.weixuan.football.test;

import android.app.FragmentTransaction;
import com.alibaba.fastjson.JSON;
import com.weixuan.football.entity.RecentGameTeam;
import com.weixuan.football.entity.Token;
import dalvik.annotation.TestTarget;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hua on 2014/8/2.
 */
public class Test {
    public static void main(String[] arg){
        //System.out.println(2014-2000);

      /*  RecentGameTeam gameTeam = new RecentGameTeam();
        System.out.println(gameTeam.getTeamBId());
        FragmentTransaction transaction;
       transaction.setCustomAnimations()*/
        String s=" {\"expires_in\":86400000,\"refresh_token\":\"483359bd5b2c44b0903b5a1428260022\",\"access_token\":\"4accd6d2d5914de6bd61360930da2cb9\"}";
        Token token=  JSON.parseObject(s, Token.class);
        System.out.println(token);

    }
}
