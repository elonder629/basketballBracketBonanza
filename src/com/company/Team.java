package com.company;

/**
 * Created by jd997 on 3/1/18.
 */
public class Team {
    public int pointsFor;
    public int pointsAgainst;
    public int games;
    public String id;

    public Team(int pts, int ptsAgainst, String idVal) {
        pointsFor = pts;
        pointsAgainst = ptsAgainst;
        games = 0;
        id = idVal;
    }

    public double pointsPercentage() {
        return (pointsFor/(pointsFor+pointsAgainst));
    }

    public double pointsPerGame() {
        return pointsFor/games;
    }
}
