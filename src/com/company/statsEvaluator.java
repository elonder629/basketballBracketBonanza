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
    
    
    
    //u can look over/check this wip to see if it's garbage or not tthank 
        static double eloDiff;
    public double findEloRating(){
        double rating = 0; //change elodiff to whatever is needed to determine elo ratings.
        //add the rating to an array
        return rating;
    }
    public double eloDifference (String teamA, String teamB){ //find values determined from findElorating from team names

        //double eloDifference = (arrayname).get(whatever index the elorating is in)
        double elodiff = 0; //change the elodiff to equal to team A's elo rating minus team B's Elo rating
        return elodiff;
    }
    public double Elo(){
        //calculate teams's probability of winning: Pr(A) = 1/10^(-eloDiff/400)+1)
        //elodiff is team A's elo rating minus Team B's Elo Rating
        //so like we predict all of them of who will win out of them all (let's think abuot the number of teams later
        //make an arraylist to find the top winner in the whole list of names and then remove that name (clear) after
        // it's determined
        double determineBestTeam = 1/Math.pow(10,-eloDiff+1/400);
        return Elo(); //change
    }

}
