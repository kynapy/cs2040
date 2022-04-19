// Kattis ID: ballotboxes
// Kattis Best: , My Timing: 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BallotBoxes {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        while (true) {
            String testcase[] = br.readLine().split(" ");
            if (testcase[0].equals("-1")) {
                break;
            } else {
                PriorityQueue<City> pq = new PriorityQueue<City>();
                int numCities = Integer.parseInt(testcase[0]);
                int numBoxes = Integer.parseInt(testcase[1]);
                numBoxes -= numCities; // Ensuring one box per city

                // Reading input for the city populations
                for (int city = 0; city < numCities; city++) {
                    int population = Integer.parseInt(br.readLine());
                    pq.offer(new City(1, population));
                }

                // Allocating remaining excess boxes
                while (numBoxes != 0) {
                    numBoxes -= 1;
                    City largest = pq.poll();
                    pq.offer(new City(largest.boxes+1, largest.population));
                }
                
                // Printing result for test case
                pw.println((int) pq.poll().populationPerBox);
                br.readLine();
            }
        }
        pw.close();
    }
}

class City implements Comparable<City> {
    public int boxes;
    public int population;
    public double populationPerBox;

    City(int boxes, int population) {
        this.boxes = boxes;
        this.population = population;
        this.populationPerBox = Math.ceil(population/boxes);
    }

    @Override
    public int compareTo(City other) {
        if (other.populationPerBox - this.populationPerBox < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}