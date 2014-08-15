package com.weixuan.football.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.weixuan.football.R;
import com.weixuan.football.entity.Token;

import java.util.Calendar;
import java.util.Date;

/**
 * 工具
 * Created by Hua on 2014/7/31.
 */
public class Util {
    /************************************************url 请求 解析 method ******************************************************************/
    /*****
     *
     * @param requestApi
     * @param webModel
     * @return
     */
    public static String jointUrl(String requestApi,String webModel){
        StringBuilder builder=new StringBuilder(UrlApi.SERVER_IP);
        builder.append(webModel);
        builder.append("/");
        builder.append(requestApi);
        return builder.toString();
    }


    /***
     * token 解析
     * @param url
     * @return
     */
    public static Token convertToken(String url){
          if (isEmpty(url)) return  null;
          url=url.substring(url.indexOf("#")+1);
          String str[]=url.split("&");
        if (str==null)return null;
         Token token=new Token();
         String str0[]=null;
         try {
             for (String s:str){
                 str0=s.split("=");

                 if (Dict.ACCESS_TOKEN.equals(str0[0])){
                     token.setAccess_token(str0[1]);
                 }else if(Dict.EXPIRES_IN.equals(str0[0])){
                      try {
                          token.setExpires_in(Long.valueOf(str0[1]));
                      }catch (Exception e){

                      }
                 }else if (Dict.REFRESH_TOKEN.equals(str0[0])){
                      token.setRefresh_token(str0[1]);
                 }else if(Dict.STATE.equals(str0[0])){
                     try {
                         token.setState(Integer.parseInt(str0[1]));
                     }catch (Exception e){
                         token.setState(0);
                     }
                 }
             }
             return token;
         }catch (Exception e){
           return null;
         }

    }

    /************************************************View 控制  method ******************************************************************/

    /****
     * 设置球队logo
     * @param targetView
     * @param teamId 球队id
     */
   public  static void setTeamIconBg(View  targetView,Integer teamId){
        targetView.setBackgroundResource(R.drawable.logo_guo_an);
   }

    /**
     * Fragment 跳转
     * @param fm
     * @param fragmentClass
     * @param args
     * @param layoutid
     */
    public static void turnToFragment(FragmentManager fm, Class<? extends Fragment> fragmentClass,Bundle args,int layoutid) {
        Fragment fragment = fm.findFragmentByTag(fragmentClass.getSimpleName());
        boolean isFragmentExist = true;
        if (fragment == null) {
            try {
                isFragmentExist = false;
                fragment = fragmentClass.newInstance();
                fragment.setArguments(new Bundle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(fragment.isAdded()){
            return;
        }
        if( args != null && !args.isEmpty() ) {
            fragment.getArguments().putAll(args);
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        if( isFragmentExist ) {
            ft.replace(layoutid, fragment);
        } else {
            ft.replace(layoutid, fragment, fragmentClass.getSimpleName());
        }
        ft.addToBackStack(fragmentClass.getSimpleName());
        ft.commitAllowingStateLoss();
    }

    /************************************************数据 method ******************************************************************/

    /***
     * 初始化时间
     * @param startYear  开始年份>今年
     * @return
     */
    public static Integer[]  getYearList(int startYear){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        int endYear=calendar.get(Calendar.YEAR);
        int length=endYear-startYear+1;
        Integer yearList[]=new Integer[length];
        for (int i=0;i<length;i++){
            yearList[i]=endYear-i;
        }
        return yearList;
    }

    /**
     *判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
      return (null==str||"".equals(str))?true:false;
    }

}
