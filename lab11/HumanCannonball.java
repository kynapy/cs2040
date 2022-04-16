// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class HumanCannonball {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code
        String curr[] = br.readLine().split(" ");
        String target[] = br.readLine().split(" ");
        int numCannons = Integer.parseInt(br.readLine());
        Pair cannons[] = new Pair[numCannons+2];
        cannons[0] = new Pair(Double.parseDouble(curr[0]), Double.parseDouble(curr[1]));
        cannons[numCannons+1] = new Pair(Double.parseDouble(target[0]), Double.parseDouble(target[1]));
        
        // Reading in all the cannon coordinates
        for (int i = 1; i < numCannons+1; i++) {
            String cannon[] = br.readLine().split(" ");
            cannons[i] = new Pair(Double.parseDouble(cannon[0]), Double.parseDouble(cannon[1]));
        }

        // Creating adjacency list
        ArrayList<ArrayList<Double>> adjlist = new ArrayList<ArrayList<Double>>(numCannons+1);
        adjlist.add(0, new ArrayList<Double>());
        for (int i = 1; i < numCannons + 2; i++) {
            double distance = Pair.distanceFrom(cannons[0], cannons[i]);
            adjlist.get(0).add(distance/5);
        }
        for (int i = 1; i < numCannons + 1; i++) {
            adjlist.add(i, new ArrayList<Double>());
            for (int j = 0; j < numCannons + 2; j++) {
                if (i == j) {
                    continue;
                } else {
                    double timeTaken = 2;
                    double distance = Pair.distanceFrom(cannons[i], cannons[j]) - 50;
                    if (distance < 0) {
                        timeTaken += distance * -1 / 5;
                    } else {
                        timeTaken += distance / 5;
                    }
                    adjlist.get(i).add(timeTaken);
                }
            }
        }
        pw.println(adjlist);

        pw.close();
    }
}

class Pair {
    public double x;
    public double y;

    Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static double distanceFrom(Pair from, Pair to) {
        return Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
    }
}