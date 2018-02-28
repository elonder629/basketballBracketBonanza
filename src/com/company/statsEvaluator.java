package com.company;

/**
 * Created by el693 on 2/28/18.
 */
public class statsEvaluator {
    public statsEvaluator(){

    }

    public double pythagoreanPercentageCalc(int pointsFor, int pointsAgainst, int gamesPlayed){
        return gamesPlayed*(Math.pow(pointsFor,16.5)/(Math.pow(pointsFor,16.5) + Math.pow(pointsAgainst,16.5)));
    }

    public


}
