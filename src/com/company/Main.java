package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<String> teamIDs = new ArrayList<String>();
    public static ArrayList<Team> bracket = new ArrayList<Team>();

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults_Prelim2018.csv"));
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
            scanner2.useDelimiter(",");
            if (scanner2.next().equals("2018")) { //if only testing 2018
                scanner2.next();
                String winningTeam = scanner2.next();
                int winScore = scanner2.nextInt();
                String losingTeam = scanner2.next();
                int lossScore = scanner2.nextInt();
                char loc = scanner2.next().charAt(0);
                scanner2.close();
                Team w;
                Team l;
                w = teams.get(teamIDs.indexOf(winningTeam));
                w.pointsFor += winScore;
                w.pointsAgainst += lossScore;
                w.games++;
                l = teams.get(teamIDs.indexOf(losingTeam));
                l.pointsFor += lossScore;
                l.pointsAgainst += winScore;
                l.games++;
                Elo.applyEloChange(w, winScore, l, lossScore, loc);
            }
        }
        scanner.close();
        for (int i=0; i<teams.size(); i++) {
            statsEvaluator.ranking(0, teams.get(i));
        }
        statsEvaluator.rankPrint();
        //populatebracket2018();
        //statsEvaluator.predictBracket();
    }

    public static void populateBracket2016() {
        //This is very messy. I know.

        //South Division
        bracket.add(teams.get(teamIDs.indexOf("1242"))); //1
        bracket.add(teams.get(teamIDs.indexOf("1122"))); //16
        bracket.add(teams.get(teamIDs.indexOf("1160"))); //8
        bracket.add(teams.get(teamIDs.indexOf("1163"))); //9
        bracket.add(teams.get(teamIDs.indexOf("1268"))); //5
        bracket.add(teams.get(teamIDs.indexOf("1377"))); //12
        bracket.add(teams.get(teamIDs.indexOf("1143"))); //4
        bracket.add(teams.get(teamIDs.indexOf("1218"))); //13
        bracket.add(teams.get(teamIDs.indexOf("1112"))); //6
        bracket.add(teams.get(teamIDs.indexOf("1455"))); //11
        bracket.add(teams.get(teamIDs.indexOf("1274"))); //3
        bracket.add(teams.get(teamIDs.indexOf("1138"))); //14
        bracket.add(teams.get(teamIDs.indexOf("1234"))); //7
        bracket.add(teams.get(teamIDs.indexOf("1396"))); //10
        bracket.add(teams.get(teamIDs.indexOf("1437"))); //2
        bracket.add(teams.get(teamIDs.indexOf("1421"))); //15

        //West Division
        bracket.add(teams.get(teamIDs.indexOf("1332"))); //1
        bracket.add(teams.get(teamIDs.indexOf("1221"))); //16
        bracket.add(teams.get(teamIDs.indexOf("1386"))); //8
        bracket.add(teams.get(teamIDs.indexOf("1153"))); //9
        bracket.add(teams.get(teamIDs.indexOf("1124"))); //5
        bracket.add(teams.get(teamIDs.indexOf("1463"))); //12
        bracket.add(teams.get(teamIDs.indexOf("1181"))); //4
        bracket.add(teams.get(teamIDs.indexOf("1423"))); //13
        bracket.add(teams.get(teamIDs.indexOf("1400"))); //6
        bracket.add(teams.get(teamIDs.indexOf("1320"))); //1
        bracket.add(teams.get(teamIDs.indexOf("1401"))); //3
        bracket.add(teams.get(teamIDs.indexOf("1453"))); //14
        bracket.add(teams.get(teamIDs.indexOf("1333"))); //7
        bracket.add(teams.get(teamIDs.indexOf("1433"))); //10
        bracket.add(teams.get(teamIDs.indexOf("1328"))); //2
        bracket.add(teams.get(teamIDs.indexOf("1167"))); //15

        //East Division
        bracket.add(teams.get(teamIDs.indexOf("1314"))); //1
        bracket.add(teams.get(teamIDs.indexOf("1195"))); //16
        bracket.add(teams.get(teamIDs.indexOf("1425"))); //8
        bracket.add(teams.get(teamIDs.indexOf("1344"))); //9
        bracket.add(teams.get(teamIDs.indexOf("1231"))); //5
        bracket.add(teams.get(teamIDs.indexOf("1151"))); //12
        bracket.add(teams.get(teamIDs.indexOf("1246"))); //4
        bracket.add(teams.get(teamIDs.indexOf("1392"))); //13
        bracket.add(teams.get(teamIDs.indexOf("1323"))); //6
        bracket.add(teams.get(teamIDs.indexOf("1276"))); //11
        bracket.add(teams.get(teamIDs.indexOf("1452"))); //3
        bracket.add(teams.get(teamIDs.indexOf("1372"))); //14
        bracket.add(teams.get(teamIDs.indexOf("1458"))); //7
        bracket.add(teams.get(teamIDs.indexOf("1338"))); //10
        bracket.add(teams.get(teamIDs.indexOf("1462"))); //2
        bracket.add(teams.get(teamIDs.indexOf("1451"))); //15

        //Midwest Division
        bracket.add(teams.get(teamIDs.indexOf("1438"))); //1
        bracket.add(teams.get(teamIDs.indexOf("1214"))); //16
        bracket.add(teams.get(teamIDs.indexOf("1403"))); //8
        bracket.add(teams.get(teamIDs.indexOf("1139"))); //9
        bracket.add(teams.get(teamIDs.indexOf("1345"))); //5
        bracket.add(teams.get(teamIDs.indexOf("1114"))); //12
        bracket.add(teams.get(teamIDs.indexOf("1235"))); //4
        bracket.add(teams.get(teamIDs.indexOf("1233"))); //13
        bracket.add(teams.get(teamIDs.indexOf("1371"))); //6
        bracket.add(teams.get(teamIDs.indexOf("1211"))); //11
        bracket.add(teams.get(teamIDs.indexOf("1428"))); //3
        bracket.add(teams.get(teamIDs.indexOf("1201"))); //14
        bracket.add(teams.get(teamIDs.indexOf("1173"))); //7
        bracket.add(teams.get(teamIDs.indexOf("1393"))); //10
        bracket.add(teams.get(teamIDs.indexOf("1277"))); //2
        bracket.add(teams.get(teamIDs.indexOf("1292"))); //15
    }

    public static void populatebracket2018() {
        // South Division
        bracket.add(teams.get(teamIDs.indexOf("1438")));
        bracket.add(teams.get(teamIDs.indexOf("1420")));
        bracket.add(teams.get(teamIDs.indexOf("1166")));
        bracket.add(teams.get(teamIDs.indexOf("1243")));
        bracket.add(teams.get(teamIDs.indexOf("1246")));
        bracket.add(teams.get(teamIDs.indexOf("1172")));
        bracket.add(teams.get(teamIDs.indexOf("1112")));
        bracket.add(teams.get(teamIDs.indexOf("1138")));
        bracket.add(teams.get(teamIDs.indexOf("1274")));
        bracket.add(teams.get(teamIDs.indexOf("1260")));
        bracket.add(teams.get(teamIDs.indexOf("1397")));
        bracket.add(teams.get(teamIDs.indexOf("1460")));
        bracket.add(teams.get(teamIDs.indexOf("1305")));
        bracket.add(teams.get(teamIDs.indexOf("1400")));
        bracket.add(teams.get(teamIDs.indexOf("1153")));
        bracket.add(teams.get(teamIDs.indexOf("1209")));

        //West Division
        bracket.add(teams.get(teamIDs.indexOf("1462")));
        bracket.add(teams.get(teamIDs.indexOf("1300")));//NC Central
        bracket.add(teams.get(teamIDs.indexOf("1411")));//Texas So.
        bracket.add(teams.get(teamIDs.indexOf("1281")));
        bracket.add(teams.get(teamIDs.indexOf("1199")));
        bracket.add(teams.get(teamIDs.indexOf("1326")));
        bracket.add(teams.get(teamIDs.indexOf("1355")));
        bracket.add(teams.get(teamIDs.indexOf("1211")));
        bracket.add(teams.get(teamIDs.indexOf("1422")));
        bracket.add(teams.get(teamIDs.indexOf("1222")));
        bracket.add(teams.get(teamIDs.indexOf("1361")));
        bracket.add(teams.get(teamIDs.indexOf("1276")));
        bracket.add(teams.get(teamIDs.indexOf("1285")));
        bracket.add(teams.get(teamIDs.indexOf("1401")));
        bracket.add(teams.get(teamIDs.indexOf("1344")));
        bracket.add(teams.get(teamIDs.indexOf("1314")));
        bracket.add(teams.get(teamIDs.indexOf("1252")));

        //East Division
        bracket.add(teams.get(teamIDs.indexOf("1437")));
        bracket.add(teams.get(teamIDs.indexOf("1134"))); //LIU Brooklyn
        bracket.add(teams.get(teamIDs.indexOf("1347"))); //Radford
        bracket.add(teams.get(teamIDs.indexOf("1439")));
        bracket.add(teams.get(teamIDs.indexOf("1104")));
        bracket.add(teams.get(teamIDs.indexOf("1452")));
        bracket.add(teams.get(teamIDs.indexOf("1293")));
        bracket.add(teams.get(teamIDs.indexOf("1455")));
        bracket.add(teams.get(teamIDs.indexOf("1267")));
        bracket.add(teams.get(teamIDs.indexOf("1196")));
        bracket.add(teams.get(teamIDs.indexOf("1382"))); //St. Bonaventure
        bracket.add(teams.get(teamIDs.indexOf("1417"))); //UCLA
        bracket.add(teams.get(teamIDs.indexOf("1403")));
        bracket.add(teams.get(teamIDs.indexOf("1372")));
        bracket.add(teams.get(teamIDs.indexOf("1116")));
        bracket.add(teams.get(teamIDs.indexOf("1139")));
        bracket.add(teams.get(teamIDs.indexOf("1345")));
        bracket.add(teams.get(teamIDs.indexOf("1168")));

        //Midwest Division
        bracket.add(teams.get(teamIDs.indexOf("1242")));
        bracket.add(teams.get(teamIDs.indexOf("1335")));
        bracket.add(teams.get(teamIDs.indexOf("1371")));
        bracket.add(teams.get(teamIDs.indexOf("1301")));
        bracket.add(teams.get(teamIDs.indexOf("1155")));
        bracket.add(teams.get(teamIDs.indexOf("1308")));
        bracket.add(teams.get(teamIDs.indexOf("1120")));
        bracket.add(teams.get(teamIDs.indexOf("1158")));
        bracket.add(teams.get(teamIDs.indexOf("1395")));
        bracket.add(teams.get(teamIDs.indexOf("1113"))); //Arizona St
        bracket.add(teams.get(teamIDs.indexOf("1393"))); //Syracuse
        bracket.add(teams.get(teamIDs.indexOf("1277")));
        bracket.add(teams.get(teamIDs.indexOf("1137")));
        bracket.add(teams.get(teamIDs.indexOf("1348")));
        bracket.add(teams.get(teamIDs.indexOf("1328")));
        bracket.add(teams.get(teamIDs.indexOf("1181")));
        bracket.add(teams.get(teamIDs.indexOf("1233")));
    }
}
