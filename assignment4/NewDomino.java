// Kattis ID: millionairemadness
// Time taken: 0.92s, Fastest time: 0.16s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.ArrayList;

public class NewDomino {
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
            
            // Storage in Adjacency List
            ArrayList adjlist[] = new ArrayList[numTiles + 1];
            for (int j = 0; j < numTiles + 1; j++) {
                adjlist[j] = new ArrayList<Integer>();
            }
            // Each line indicates if dominoX falls, dominoY falls
            for (int j = 0; j < numLines; j++) {
                String line[] = br.readLine().split(" ");
                int dominoX = Integer.parseInt(line[0]);
                int dominoY = Integer.parseInt(line[1]);
                if (dominoX != dominoY) {
                    adjlist[dominoX].add(dominoY);
                }
            }

            // Generating topological order
            HashSet<Integer> visited = new HashSet<Integer>();
            ArrayList<Integer> llist = new ArrayList<Integer>();
            for (int j = 1; j < numTiles+1; j++) {
                Kosaraju.DFSrec(j, visited, adjlist, llist);
            }

            // Running DFS 
            HashSet<Integer> toppled = new HashSet<Integer>();
            int result = 0;
            for (int j = numTiles-1; j >= 0; j--) {
                int vertex = llist.get(j);
                if (Kosaraju.DFSToppling(vertex, adjlist, toppled)) {
                    result += 1;
                }
            }
            pw.println(result);
        }
        pw.close();
    }
}

class Kosaraju {
    // Recursive DFS
    public static void DFSrec(int vertex, HashSet<Integer> visited, ArrayList adjlist[], ArrayList<Integer> list) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (int i = 0; i < adjlist[vertex].size(); i++) {
                DFSrec((int) adjlist[vertex].get(i), visited, adjlist, list);
            }
            list.add(vertex);
        }
    }

    public static boolean DFSToppling(int vertex, ArrayList adjlist[], HashSet<Integer> toppled) {
        if (!toppled.contains(vertex)) {
            toppled.add(vertex);
            for (int i = 0; i < adjlist[vertex].size(); i++) {
                if (!toppled.contains(adjlist[vertex].get(i))) {
                    DFSToppling( (int) adjlist[vertex].get(i), adjlist, toppled);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}