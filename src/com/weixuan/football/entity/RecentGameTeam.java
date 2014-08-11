package com.weixuan.football.entity;

import java.util.Date;

/**
 * d对战历史
 * Created by Hua on 2014/8/2.
 */
public class RecentGameTeam {
   private Integer  id;
   private String events="中超";//赛事
   private Integer  season;//赛季
   private Integer  round;//轮次
   private Date  date;//开赛日期
   private Integer teamAId;//主队id
   private String teamAName;//主队名称
   private Integer teamBId;//客队id
   private  String teamBName;//客队名称
   private String score;//比分
   private String status;//N（未开赛）|F（完赛）|I（正在进行中）
   private Date  gameTime;//当status为I是才会有值，比赛进行的有效时间
   private String  res;//比赛结果，A（主队胜）| B（客队胜）| C（平）

    @Override
    public String toString() {
        return "RecentGameTeam{" +
                "id=" + id +
                ", events='" + events + '\'' +
                ", season=" + season +
                ", round=" + round +
                ", date=" + date +
                ", teamAId=" + teamAId +
                ", teamAName='" + teamAName + '\'' +
                ", teamBId=" + teamBId +
                ", teamBName='" + teamBName + '\'' +
                ", score='" + score + '\'' +
                ", status='" + status + '\'' +
                ", gameTime=" + gameTime +
                ", res='" + res + '\'' +
                '}';
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Integer teamAId) {
        this.teamAId = teamAId;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public Integer getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Integer teamBId) {
        this.teamBId = teamBId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }
}
