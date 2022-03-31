// Kattis ID: weakvertices
// Time taken: 0.15s, Fastest time: 0.07s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WeakVertices {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        while (true) {
            int numVertices = Integer.parseInt(br.readLine());
            if (numVertices == -1) {
                break;
            }

            // Read every line of links
            ArrayList<ArrayList<Integer>> vertices = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < numVertices; i++) {
                String[] links = br.readLine().split(" ");
                ArrayList<Integer> linkList = new ArrayList<Integer>();
                for (int j = 0; j < numVertices; j++) {
                    if (links[j].equals("1")) {
                        linkList.add(j);
                    }
                }
                vertices.add(linkList);
            }

            // Checking for triangles
            for (int i = 0; i < numVertices; i++) {
                ArrayList<Integer> neighboursOfI = vertices.get(i);
                boolean trianglePart = false;
                for (int j = 0; j < neighboursOfI.size(); j++) {
                    int neighbour = neighboursOfI.get(j);
                    ArrayList<Integer> neighbourOfNeighbour = vertices.get(neighbour);
                    for (int k = 0; k < neighbourOfNeighbour.size(); k++) {
                        if (vertices.get(neighbourOfNeighbour.get(k)).contains(i)) {
                            trianglePart = true;
                        }
                    }
                }
                if (!trianglePart) {
                    pw.print(i + " ");
                }
            }
            pw.println();
        }
        pw.close();
    }
}