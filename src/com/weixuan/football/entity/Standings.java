package com.weixuan.football.entity;

/**
 * 积分榜
 * Created by Hua on 2014/8/2.
 */
public class Standings {
    private int  no;//名次
    private int  session;//场次
    private int win;//胜场次
    private int draw;//平场次
    private int lose;//输场次
    private String jsq;//净胜球
    private int score;//积分
    private  String team;//球队

    @Override
    public String toString() {
        return "Standings{" +
                "no=" + no +
                ", session=" + session +
                ", win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                ", jsq=" + jsq +
                ", score=" + score +
                ", team='" + team + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public String getJsq() {
        return jsq;
    }

    public void setJsq(String jsq) {
        this.jsq = jsq;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
