package com.company;

/**
 * Created by John on 3/3/2018.
 */
public class Elo {

    public Elo() {

    }

    public static void applyEloChange(Team winningTeam, int winScore, Team losingTeam, int lossScore, char homeCourt) {
        double wElo = winningTeam.elo;
        double lElo = losingTeam.elo;
        if (homeCourt == 'W') {
            wElo += 100;
        } else if (homeCourt == 'L') {
            lElo += 100;
        }
        double eloDiff = wElo - lElo;
        double wExpected = 1/(1+Math.pow(10, (lElo-wElo)/400));
        double lExpected = 1/(1+Math.pow(10, (wElo-lElo)/400));
        double victoryMarginMultiplier = (Math.pow((winScore-lossScore)+3, .8))/(7.5+(.006*eloDiff));
        winningTeam.elo += (int)(20*victoryMarginMultiplier*(1.0-wExpected));
        losingTeam.elo += (int)(20*victoryMarginMultiplier*(0.0-lExpected));
    }

    public static void bracketElo(Team winningTeam, Team losingTeam, char homeCourt) {
        double wElo = winningTeam.elo;
        double lElo = losingTeam.elo;
        if (homeCourt == 'W') {
            wElo += 100;
        } else if (homeCourt == 'L') {
            lElo += 100;
        }
        double eloDiff = wElo - lElo;
        double wExpected = 1/(1+Math.pow(10, (lElo-wElo)/400));
        double lExpected = 1/(1+Math.pow(10, (wElo-lElo)/400));
        winningTeam.elo += (int)(20*(1.0-wExpected));
        losingTeam.elo += (int)(20*(0.0-lExpected));
    }
}
