// Ang Ping Young (A0199498X)
// Kattis Best: 0., My Timing: 0. 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.ArrayList;

public class Classy {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code
        int numOfCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCases; i++) {

            // For each case
            int numOfPeople = Integer.parseInt(br.readLine());
            ArrayList<People> everyone = new ArrayList<People>();
            
            // For each person
            for (int j = 0; j < numOfPeople; j++) {
                String[] details = br.readLine().split(" ");
                String name = details[0].split(":")[0];
                String[] classChain = details[1].split("-");
                long rank = 0;
                int chainLength = classChain.length-1;
                for (int k = 0; k < 10; k++) {
                    if (k <= chainLength) {
                        rank += rankToInt(classChain[chainLength-k]) * Math.pow(10, 9-k);
                    } else {
                        rank += 1 * Math.pow(10, 9-k);
                    }
                }
                everyone.add(new People(name, rank));
            }

            // Sort by rank and print in sequence
            Collections.sort(everyone);
            for (int j = 0; j < numOfPeople; j++) {
                pw.println(everyone.get(j).name);
            }
            
            // Printing end of case
            pw.println("==============================");
        }
        pw.close();
    }

    static int rankToInt(String rank) {
            if (rank.equals("upper")) {
                return 2;
            }
            else if (rank.equals("middle")) {
                return 1;
            } else {
                return 0;
            }
        }
}

class People implements Comparable<People> {
    public final String name;
    public final long rank;

    People(String name, long rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(People other) {
        long result = other.rank - this.rank;
        if (result == 0) {
            return this.name.compareTo(other.name);
        } 
        else if (result < 0) {
            return -1;
        } else { 
            return 1;
        }
    }
}