package com.weixuan.football.entity;

import java.util.Arrays;

/**
 *对战历史
 * Created by Hua on 2014/8/2.
 */
public class AgainstHistorical {
   private Integer num;//两队公开战过几场
   private Integer win;//主队胜了几场
   private Integer ping;//主队平了几场
   private Integer  fu;//主队输了几场
   private RecentGameTeam[] items;//场次结合

    @Override
    public String toString() {
        return "AgainstHistorical{" +
                "num=" + num +
                ", win=" + win +
                ", ping=" + ping +
                ", fu=" + fu +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPing() {
        return ping;
    }

    public void setPing(Integer ping) {
        this.ping = ping;
    }

    public Integer getFu() {
        return fu;
    }

    public void setFu(Integer fu) {
        this.fu = fu;
    }

    public RecentGameTeam[] getItems() {
        return items;
    }

    public void setItems(RecentGameTeam[] items) {
        this.items = items;
    }
}
