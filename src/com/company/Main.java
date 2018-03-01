package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults.tsv"));
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<String> teamIDs = new ArrayList<String>();
        boolean flag = false;
        while(scanner.hasNext()) {
            if(!flag) {
                flag = true;
                continue;
            }
            String line = scanner.nextLine();
            Scanner scanner2 = new Scanner(line);
            if (scanner2.next().equals("2017")) {
                break;
            }
            scanner2.next();
            String winningTeam = scanner2.next();
            int winScore = scanner2.nextInt();
            String losingTeam = scanner2.next();
            int lossScore = scanner2.nextInt();
            if (!teamIDs.contains(winningTeam)) {
                teams.add(new Team(winningTeam));
                teams.get(teams.size()-1).pointsFor += winScore;
                teams.get(teams.size()-1).pointsAgainst += lossScore;
            } else {
                teams.get(teamIDs.indexOf(winningTeam)).pointsFor += winScore;
                teams.get(teamIDs.indexOf(winningTeam)).pointsAgainst += lossScore;
            }
            if (!teamIDs.contains(losingTeam)) {
                teams.add(new Team(losingTeam));
                teams.get(teams.size()-1).pointsFor += lossScore;
            }
        }
    }
}
