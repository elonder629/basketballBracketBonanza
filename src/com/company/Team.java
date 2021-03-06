package com.company;

/**
 * Created by jd997 on 3/1/18.
 */
public class Team {
    public int pointsFor;
    public int pointsAgainst;
    public int games;
    public String id;
    public int elo;
    public String name;
    public double scoreOfEvluator;

    public Team(String teamName, String idVal) {
        pointsFor = 0;
        pointsAgainst = 0;
        games = 0;
        id = idVal;
        elo = 1500;
        name = teamName;
    }

    public double pointsPercentage() {
        return (pointsFor/(pointsFor+pointsAgainst));
    }

    public double pointsPerGame() {
        return pointsFor/games;
    }
}
