package com.company;

/**
 * Created by el693 on 2/28/18.
 */
public class statsEvaluator {

    public static double pythagoreanPercentageCalc(int pointsFor, int pointsAgainst, int gamesPlayed){
        return gamesPlayed*(Math.pow(pointsFor,16.5)/(Math.pow(pointsFor,16.5) + Math.pow(pointsAgainst,16.5)));
    }

    public static double gameScoreCalc(int points, int fieldGoals
            , int FGA, int FT, int FTA, int ORB, int DRB, int steals
            , int assists, int blocks, int personalFouls, int turnovers){
        return points +(0.4*fieldGoals)- (0.7*FGA) - (0.4*(FTA - FT)) + (0.7 * ORB) + ()
    }

}
