package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<String> teamIDs = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults.tsv"));
        boolean flag = true;
        while(scanner.hasNextLine()) {
            if (flag) {
                scanner.nextLine();
                flag = false;
                continue;
            }
            String line = scanner.nextLine();
            Scanner scanner2 = new Scanner(line);
            scanner2.useDelimiter("\t");
            if (scanner2.next().equals("2017")) {
                break;
            }
            scanner2.next();
            String winningTeam = scanner2.next();
            int winScore = scanner2.nextInt();
            String losingTeam = scanner2.next();
            int lossScore = scanner2.nextInt();
            char loc = scanner2.next().charAt(0);
            Team w;
            Team l;
            if (!teamIDs.contains(winningTeam)) {
                w = new Team(winningTeam);
                teams.add(w);
                w.pointsFor += winScore;
                w.pointsAgainst += lossScore;
            } else {
                w = teams.get(teamIDs.indexOf(winningTeam));
                w.pointsFor += winScore;
                w.pointsAgainst += lossScore;
            }
            if (!teamIDs.contains(losingTeam)) {
                l = new Team(losingTeam);
                teams.add(l);
                l.pointsFor += lossScore;
                l.pointsAgainst += winScore;
            } else {
                l = teams.get(teamIDs.indexOf(losingTeam));
                l.pointsFor += lossScore;
                l.pointsAgainst += winScore;
            }
            Elo.applyEloChange(w, winScore, l, lossScore, loc);
        }
    }
}
