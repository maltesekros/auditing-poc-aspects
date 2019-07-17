package com.tipico.auditingpoc.bo;

public class Match {

    private Team team1;
    private Team team2;
    private String sport;

    public Match(Team team1, Team team2, String date) {
        this.team1 = team1;
        this.team2 = team2;
        this.sport = sport;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getSport() {
        return sport;
    }
}
