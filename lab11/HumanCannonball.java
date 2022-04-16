// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Collections;

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
        ArrayList<ArrayList<Edge>> adjlist = new ArrayList<ArrayList<Edge>>(numCannons+2);
        adjlist.add(0, new ArrayList<Edge>());
        for (int i = 1; i < numCannons + 2; i++) {
            double distance = Pair.distanceFrom(cannons[0], cannons[i]);
            adjlist.get(0).add(new Edge(i, distance/5));
        }
        for (int i = 1; i < numCannons + 2; i++) {
            adjlist.add(i, new ArrayList<Edge>());
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
                    adjlist.get(i).add(new Edge(j, timeTaken));
                }
            }
        }

        // Dijkstra implementation
        // Initialise SSSP
        double INF = 100000000;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        double shortest[] = new double[numCannons + 2];
        pq.offer(new Edge(0, 0));
        for (int i = 1; i < numCannons+2; i++) {
            pq.offer(new Edge(i, INF));
        }
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if () {
                for () {
                    if () {

                    }
                }
            }
        }

        // Printing results
        //pw.println(shortest[numCannons+1]);
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

class Edge implements Comparable<Edge> {
    int to;
    double weight;

    Edge(int to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.weight == other.weight) {
            return this.to - other.to;
        } else if (this.weight < other.weight) {
            return -1;
        } else {
            return 1;
        }
    }
}