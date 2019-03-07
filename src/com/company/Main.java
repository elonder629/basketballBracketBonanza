package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<String> teamIDs = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scannerT = new Scanner(new File("Teams.tsv"));
        boolean flag = true;
        while(scannerT.hasNext()) {
            if (flag) {
                scannerT.nextLine();
                flag = false;
                continue;
            }
            String line = scannerT.nextLine();
            Scanner scannerT2 = new Scanner(line);
            scannerT2.useDelimiter("\t");
            String id = scannerT2.next();
            String name = scannerT2.next();
            scannerT2.close();
            teams.add(new Team(name, id));
            teamIDs.add(id);
        }
        scannerT.close();
        flag = true;
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults.tsv"));
        while(scanner.hasNextLine()) {
            if (flag) {
                scanner.nextLine();
                flag = false;
                continue;
            }
            String line = scanner.nextLine();
            Scanner scanner2 = new Scanner(line);
            scanner2.useDelimiter("\t");
            if (scanner2.next().equals("2017")) { //if only testing 2016
                break;
            }
            scanner2.next();
            String winningTeam = scanner2.next();
            int winScore = scanner2.nextInt();
            String losingTeam = scanner2.next();
            int lossScore = scanner2.nextInt();
            char loc = scanner2.next().charAt(0);
            scanner2.close();
            Team w;
            Team l;
            /*if (!teamIDs.contains(winningTeam)) {
                w = new Team(winningTeam);
                teams.add(w);
                w.pointsFor += winScore;
                w.pointsAgainst += lossScore;
            } else {*/
                w = teams.get(teamIDs.indexOf(winningTeam));
                w.pointsFor += winScore;
                w.pointsAgainst += lossScore;
            //}
            /*if (!teamIDs.contains(losingTeam)) {
                l = new Team(losingTeam);
                teams.add(l);
                l.pointsFor += lossScore;
                l.pointsAgainst += winScore;
            } else {*/
                l = teams.get(teamIDs.indexOf(losingTeam));
                l.pointsFor += lossScore;
                l.pointsAgainst += winScore;
            //}
            Elo.applyEloChange(w, winScore, l, lossScore, loc);
        }
        scanner.close();
    }
}
