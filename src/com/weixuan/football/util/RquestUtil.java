package com.weixuan.football.util;

import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;

/**
 * Created by Hua on 2014/8/12.
 */
public class RquestUtil {
    /****
     * 请求最近一次比赛信息
     * @return
     */
    public static Object requestRecently(String userToken,int team_id){
        Request req = new Request(Util.jointUrl(UrlApi.RECENTLY,UrlApi.WEB_MODEL_BASE)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.TEAM_ID, String.valueOf(8)).addUrlParam(Dict.ACCESS_TOKEN,userToken);
        return null;
    }

    public static Object requestWarHistory(){
        Request req = new Request(Util.jointUrl(UrlApi.WAR_HISTORY,UrlApi.WEB_MODEL_BASE)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.TEAM_B_ID, String.valueOf(8)).addUrlParam(Dict.TEAM_B_ID, String.valueOf(8))
                .addUrlParam(Dict.ACCESS_TOKEN,"token");

        return null;
    }
    public static Object requestRecentRecord(){
        Request req = new Request(Util.jointUrl(UrlApi.RECENT_RECORD,UrlApi.WEB_MODEL_BASE)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.TEAM_ID, String.valueOf(8))
                .addUrlParam(Dict.ACCESS_TOKEN,"token");

        return null;
    }

}
