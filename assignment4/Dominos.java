// Old attempt, works but runs too slow

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dominos {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code
        // Number of test cases
        int numCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCases; i++) {
            String input[] = br.readLine().split(" ");
            int numTiles = Integer.parseInt(input[0]); // The number of tiles from 1 to n
            int numLines = Integer.parseInt(input[1]); // The number of lines indicating domino effect
            ArrayList edgelist[] = new ArrayList[numTiles+1];
            HashSet<Integer> toppled = new HashSet<Integer>(numTiles+1);
            HashSet<Integer> start = new HashSet<Integer>();

            // Each line indicates if dominoX falls, dominoY falls
            for (int j = 0; j < numTiles+1; j++) {
                edgelist[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < numLines; j++) {
                String line[] = br.readLine().split(" ");
                int dominoX = Integer.parseInt(line[0]);
                int dominoY = Integer.parseInt(line[1]);
                if (dominoX != dominoY) {
                    edgelist[dominoX].add(dominoY);
                }
            }
            for (int j = 1; j < numTiles + 1; j++) {
                if (!toppled.contains(j)) {
                    toppled.add(j);
                    start.add(j);
                    HashSet<Integer> visited = new HashSet<Integer>();
                    visited.add(j);
                    LinkedList<Integer> processList = new LinkedList<Integer>();
                    for (int k = 0; k < edgelist[j].size(); k++) {
                        int neighbour = (int) edgelist[j].get(k);
                        processList.offer(neighbour);
                        toppled.add(neighbour);
                        visited.add(neighbour);
                    }
                    while (!processList.isEmpty()) {
                        int x = processList.poll();
                        if (start.contains(x)) {
                            start.remove(x);
                        }
                        for (int z = 0; z < edgelist[x].size(); z++) {
                            int beside = (int) edgelist[x].get(z);
                            if (!visited.contains(beside)) {
                                processList.offer(beside);
                                edgelist[x].set(z, 0);
                                toppled.add(beside);
                                visited.add(beside);
                            }
                        }
                    }
                    edgelist[j] = new ArrayList<Integer>();
                }
            }
            pw.println(start.size());
        }
        pw.close();
    }
}