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
