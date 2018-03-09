package com.company;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by el693 on 2/28/18.
 */
public class statsEvaluator {

    public static double pythagoreanPercentageCalc(Team team) {
        return team.games*(Math.pow(team.pointsFor, 16.5)/(Math.pow(team.pointsFor, 16.5) + Math.pow(team.pointsAgainst, 16.5)));
    }

    public static double gameScoreCalc(int points, int fieldGoals, int FGA, int FT, int FTA, int ORB, int DRB, int steals, int assists, int blocks, int personalFouls, int turnovers) {
        return points +(0.4*fieldGoals)- (0.7*FGA) - (0.4*(FTA - FT)) + (0.7 * ORB) + (0.3 * DRB) + steals + (0.7 * assists) + (0.7 * blocks) - (0.4 * personalFouls) - turnovers;
    }

    public static double fantasyBasketball(int WFGM, int WFGM3, int WFTM, int WOR, int WDR, int WAst, int WStl, int WBlk, int WTO) {
        double sum = (WFGM * 2) + (WFGM3 * 3) + WFTM + ((WOR + WDR) * 1.2) + (WAst * 1.5) + (WStl * 3) + (WBlk * 3) + (WTO * -1);
        return sum;
    }

    /*
    0 == pythagorean
    1 == Game score calc
    2 == fantasy basketball
     */

    public static void ranking(int calctype, Team x) {
        if (calctype ==  0) {
            x.scoreOfEvluator = pythagoreanPercentageCalc(x);
        }
        else if (calctype == 1) {
            //  x.scoreOfEvluator = gameScoreCalc()
        }
        else if (calctype == 2) {
            //x.scoreOfEvluator = fantasyBasketball()
        }
        //Main.teams.sort((team1, team2) -> Double.compare(team2.scoreOfEvluator, team1.scoreOfEvluator));
        //Main.teams.sort((team1, team2) -> Integer.compare(team2.elo, team1.elo));

    }

    public static void rankPrint() {
        for (int x = 0; x < Main.teams.size(); x++) {
            System.out.println(x+1 + ": " + Main.teams.get(x).name + " - " + Main.teams.get(x).elo);
        }
    }

    public static int prediction(Team team1, Team team2) {
        double eloDiff = Math.abs(team1.elo-team2.elo);
        if ((Math.pow(Math.E, (pythagoreanPercentageCalc(team1)*eloDiff))/(1+Math.pow(Math.E, (pythagoreanPercentageCalc(team1)*eloDiff)))) > .5) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void predictBracket() {
        for (int i=0; i<Main.bracket.size(); i++) {
            if (i%2 == 1) {
                Team team1 = Main.bracket.get(i-1);
                Team team2 = Main.bracket.get(i);
                if (team1.elo > team2.elo) {
                    System.out.println(team1.name + " beats " + team2.name);
                    Main.bracket.set(i, null);
                    Elo.bracketElo(team1, team2, 'N');
                } else if (team1.elo < team2.elo) {
                    System.out.println(team2.name + " beats " + team1.name);
                    Main.bracket.set(i-1, null);
                    Elo.bracketElo(team2, team1, 'N');
                } else {
                    if (Math.random() >= .5) {
                        Main.bracket.set(i, null);
                        System.out.println(team1.name + " beats " + team2.name);
                        Elo.bracketElo(team1, team2, 'N');
                    } else {
                        System.out.println(team2.name + " beats " + team1.name);
                        Main.bracket.set(i-1, null);
                        Elo.bracketElo(team2, team1, 'N');
                    }
                }
            }
        }
        System.out.println(" ");
        for (int i=0; i<Main.bracket.size(); i++) {
            if (Main.bracket.get(i) == null) {
                Main.bracket.remove(i);
                i--;
            }
        }
        if (Main.bracket.size() != 1) {
            predictBracket();
        }
    }
}
