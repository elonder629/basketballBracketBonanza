package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<String> teamIDs = new ArrayList<String>();
    public static ArrayList<Team> bracket = new ArrayList<Team>();

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults.tsv"));
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
                w.games++;
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
                l.games++;
            //}
            Elo.applyEloChange(w, winScore, l, lossScore, loc);
        }
        scanner.close();
        for (int i=0; i<teams.size(); i++) {
            statsEvaluator.ranking(0, teams.get(i));
        }
        statsEvaluator.rankPrint();
    }

    public static void populateBracket() {
        //This is very messy. I know.
        bracket.add(teams.get(teamIDs.indexOf("1242")));
        bracket.add(teams.get(teamIDs.indexOf("1122")));
        bracket.add(teams.get(teamIDs.indexOf("1160")));
        bracket.add(teams.get(teamIDs.indexOf("1163")));
        bracket.add(teams.get(teamIDs.indexOf("1268")));
        bracket.add(teams.get(teamIDs.indexOf("1377")));
        bracket.add(teams.get(teamIDs.indexOf("1143")));
        bracket.add(teams.get(teamIDs.indexOf("1218")));
        bracket.add(teams.get(teamIDs.indexOf("1112")));
        bracket.add(teams.get(teamIDs.indexOf("1455")));
        bracket.add(teams.get(teamIDs.indexOf("1274")));
        bracket.add(teams.get(teamIDs.indexOf("1138")));
        bracket.add(teams.get(teamIDs.indexOf("1234")));
        bracket.add(teams.get(teamIDs.indexOf("1396")));
        bracket.add(teams.get(teamIDs.indexOf("1437")));
        bracket.add(teams.get(teamIDs.indexOf("1421")));
        bracket.add(teams.get(teamIDs.indexOf("1332")));
        bracket.add(teams.get(teamIDs.indexOf("1221")));
        bracket.add(teams.get(teamIDs.indexOf("1386")));
        bracket.add(teams.get(teamIDs.indexOf("1153")));
        bracket.add(teams.get(teamIDs.indexOf("1124")));
        bracket.add(teams.get(teamIDs.indexOf("1463")));
        bracket.add(teams.get(teamIDs.indexOf("1181")));
        bracket.add(teams.get(teamIDs.indexOf("1423")));
        bracket.add(teams.get(teamIDs.indexOf("1400")));
        bracket.add(teams.get(teamIDs.indexOf("1320")));
        bracket.add(teams.get(teamIDs.indexOf("1401")));
        bracket.add(teams.get(teamIDs.indexOf("1453")));
        bracket.add(teams.get(teamIDs.indexOf("1333")));
        bracket.add(teams.get(teamIDs.indexOf("1433")));
        bracket.add(teams.get(teamIDs.indexOf("1328")));
        bracket.add(teams.get(teamIDs.indexOf("1167")));
        //need to finish east and midwest
    }
}
