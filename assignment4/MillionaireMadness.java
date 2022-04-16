// Kattis ID: millionairemadness
// Time taken: 1.49s, Fastest time: 0.35s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MillionaireMadness { 
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        String firstLine[] = br.readLine().split(" ");
        int length = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        int max = length * width;
        int matrix[] = new int[max];
        ArrayList<ArrayList<Edge>> adjlist = new ArrayList<ArrayList<Edge>>(length*width);

        // Reading input
        for (int i = 0; i < length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                matrix[i * width + j] = Integer.parseInt(line[j]);
            }
        }

        // Converting into an Adjacency List
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int curr = i*width + j;
                adjlist.add(new ArrayList<Edge>());
                if (i - 1 >= 0) {
                    int up = (i - 1) * width + j;
                    int difference = matrix[up] - matrix[curr];
                    if (difference <= 0) {
                        adjlist.get(curr).add(new Edge(up, 0));
                    } else {
                        adjlist.get(curr).add(new Edge(up, difference));
                    }
                }
                if (i + 1 < length) {
                    int down = (i + 1) * width + j;
                    int difference = matrix[down] - matrix[curr];
                    if (difference <= 0) {
                        adjlist.get(curr).add(new Edge(down, 0));
                    } else {
                        adjlist.get(curr).add(new Edge(down, difference));
                    }
                } 
                if (j - 1 >= 0) {
                    int left = i * width + j - 1;
                    int difference = matrix[left] - matrix[curr];
                    if (difference <= 0) {
                        adjlist.get(curr).add(new Edge(left, 0));
                    } else {
                        adjlist.get(curr).add(new Edge(left, difference));
                    }
                }
                if (j + 1 < width) {
                    int right = i * width + j + 1;
                    int difference = matrix[right] - matrix[curr];
                    if (difference <= 0) {
                        adjlist.get(curr).add(new Edge(right, 0));
                    } else {
                        adjlist.get(curr).add(new Edge(right, difference));
                    }
                }
            }
        }

        // Modified Prim's to find shortest ladder
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
        boolean visited[] = new boolean[max];
        int tallest = 0;
        for (int i = 0; i < adjlist.get(0).size(); i++) {
            pq.offer(adjlist.get(0).get(i));
        }
        visited[0] = true;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int height = edge.weight;
            int vertex = edge.receiver;
            visited[vertex] = true;
            if (height > tallest) {
                tallest = height;
            }
            if (vertex == max - 1) {
                break;
            } else {
                for (int i = 0; i < adjlist.get(vertex).size(); i++) {
                    Edge neighbour = adjlist.get(vertex).get(i);
                    if (!visited[neighbour.receiver]) {
                        pq.offer(neighbour);
                    }
                }
            }
        }
        pw.println(tallest);
        pw.close();
    }
}

class Edge implements Comparable<Edge>{
    public int receiver;
    public int weight;

    Edge(int receiver, int weight) {
        this.receiver = receiver;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return weight + " to vertex " + receiver;
    }
}