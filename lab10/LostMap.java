// Kattis ID: lostmap
// Time taken: 0.24s, Fastest time: 2.67s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class LostMap {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code
        int numVillages = Integer.parseInt(br.readLine());
        ArrayList<Triple> edgeList = new ArrayList<Triple>();
        UnionFind ufds = new UnionFind(numVillages+1);

        // For loop to parse information
        for (int village = 1; village < numVillages+1; village++) {
            String distances[] = br.readLine().split(" ");
            for (int i = village-1; i < numVillages; i++) {
                edgeList.add(new Triple(Integer.parseInt(distances[i]), village, i+1));
            }
        }
        Collections.sort(edgeList);
        for (int i = 0; i < edgeList.size(); i++) {
            Triple edge = edgeList.get(i);
            if (!ufds.isSameSet(edge.first, edge.second)) {
                ufds.unionSet(edge.first, edge.second);
                pw.println(edge.first + " " + edge.second);
            }
        }
        pw.close();
    }
}


class Triple implements Comparable<Triple> {
    public int weight;
    public int first;
    public int second;

    Triple(int weight, int first, int second) {
        this.weight = weight;
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Triple other) {
        if (!(this.weight == other.weight)) {
            return this.weight - other.weight;
        }
        else if (!(this.first == other.first)) {
            return this.first - other.first;
        } else {
            return this.second - other.second;
        }
    }
}

// UFDS for Kruskal's 
class UnionFind {
    public int[] p;
    public int[] rank;
    public int[] setSize;
    public int numSets;

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        setSize = new int[N];
        numSets = N;
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
            setSize[i] = 1;
        }
    }

    public int findSet(int i) { 
        if (p[i] == i) return i;
        else {
            p[i] = findSet(p[i]);
            return p[i]; 
        } 
    }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
            numSets--; 
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank[x] > rank[y]) { 
                p[y] = x; 
                setSize[x] = setSize[x] + setSize[y]; 
            }
            else { 
                p[x] = y; 
                setSize[y] = setSize[x] + setSize[y];
                if (rank[x] == rank[y]) 
                    rank[y] = rank[y]+1; 
            } 
        } 
    }

    public int numDisjointSets() { return numSets; }

    public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}
