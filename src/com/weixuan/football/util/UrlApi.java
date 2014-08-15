package com.weixuan.football.util;

/**
 * 网络请求
 * Created by Hua on 2014/8/2.
 */
public interface UrlApi {

    String SERVER_IP="http://114.80.68.147:9999/";
    String WEB_MODEL_BASE="base-web";
    String WEB_MODEL_CSL="csl-web";
    String AUTHORIZE="authorize";//获取授权码接口
    String ACCESS_TOKEN="access_token";//通过刷新码刷新授权码接口
    String LOGIN="login";//用户登录
    String SMS="sms";//使用短信验证接口
    String REGISTER="register";//用户注册
    String RECENTLY="recently";//获取首页的球队最近一次比赛信息（未开赛倒计时，开赛直播）
    String WAR_HISTORY="warHistory";//获取两队对战历史
    String  RECENT_RECORD="recentRecord";//获取球队历史战绩
    String  LIST="list";//获取积分榜

}
