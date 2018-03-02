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
        return points +(0.4*fieldGoals)- (0.7*FGA) - (0.4*(FTA - FT))
                + (0.7 * ORB) + (0.3 * DRB) + steals + (0.7 * assists)
                + (0.7 * blocks) - (0.4 * personalFouls) - turnovers;
    }

    public double fantasyBasketball(int WFGM, int WFGM3, int WFTM, int WOR, int WDR, int WAst, int WStl, int WBlk, int WTO){
        double sum = (WFGM * 2) + (WFGM3 * 3) + WFTM + ((WOR + WDR) * 1.2) + (WAst * 1.5) + (WStl * 3) + (WBlk * 3) + (WTO * -1);
        return sum;
    }

}
