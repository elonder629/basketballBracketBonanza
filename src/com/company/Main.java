package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("LETS GET READY TO RUMBLE");
        Scanner scanner = new Scanner(new File("RegularSeasonCompactResults.tsv"));
        ArrayList<Team> teams = new ArrayList<Team>();
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

        }
    }
}
