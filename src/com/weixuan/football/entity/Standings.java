package com.weixuan.football.entity;

/**
 * 积分榜
 * Created by Hua on 2014/8/2.
 */
public class Standings {
    private Integer  no;//名次
    private Integer  session;//场次
    private Integer win;//胜场次
    private Integer draw;//平场次
    private Integer lose;//输场次
    private String jsq;//净胜球
    private Integer score;//积分
    private  String teamName;//球队
    private Integer teamId;

    @Override
    public String toString() {
        return "Standings{" +
                "no=" + no +
                ", session=" + session +
                ", win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                ", jsq='" + jsq + '\'' +
                ", score=" + score +
                ", teamName='" + teamName + '\'' +
                ", teamId=" + teamId +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public String getJsq() {
        return jsq;
    }

    public void setJsq(String jsq) {
        this.jsq = jsq;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
