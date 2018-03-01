package com.company;

/**
 * Created by el693 on 2/28/18.
 */
public class statsEvaluator {

    public statsEvaluator() {

    }

    public double pythagoreanPercentageCalc(int pointsFor, int pointsAgainst, int gamesPlayed){
        return gamesPlayed*(Math.pow(pointsFor,16.5)/(Math.pow(pointsFor,16.5) + Math.pow(pointsAgainst,16.5)));
    }

    public double fantasyBasketball(int WFGM, int WFGM3, int WFTM, int WOR, int WDR, int WAst, int WStl, int WBlk, int WTO){
        double sum = (WFGM * 2) + (WFGM3 * 3) + WFTM + ((WOR + WDR) * 1.2) + (WAst * 1.5) + (WStl * 3) + (WBlk * 3) + (WTO * -1);
        return sum;
    }

}
