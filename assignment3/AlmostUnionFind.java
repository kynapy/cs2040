// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class AlmostUnionFind {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code

        while (true) {
            // Reading and processing first line
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            String[] inputSplit = input.split(" ");
            int numIntegers = Integer.parseInt(inputSplit[0]);
            int numCommands = Integer.parseInt(inputSplit[1]);

            // Creating the UnionFind structure
            UnionFind numbers = new UnionFind(numIntegers+1);

            // Run commands until the end
            for (int i = 0; i < numCommands; i++) {
                String[] command = br.readLine().split(" ");
                String operation = command[0];
                if (operation.equals("1")) {
                    int set1 = Integer.parseInt(command[1]);
                    int set2 = Integer.parseInt(command[2]);
                    numbers.unionSet(set1, set2);
                }
                else if (operation.equals("2")) {
                    int set1 = Integer.parseInt(command[1]);
                    int set2 = Integer.parseInt(command[2]);
                    numbers.moveSet(set1, set2);
                } else {
                    int set = Integer.parseInt(command[1]);
                    pw.println(numbers.setSize(set) + " " + numbers.sumSet(set));
                }
            }
        }
        pw.close();
    }
}

class UnionFind {
    public int p[];
    public HashSet<Integer> capos[];
    public long sum[];

    @SuppressWarnings("unchecked")
    UnionFind(int N) {
        p = new int[N];
        capos = new HashSet[N];
        sum = new long[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            capos[i] = new HashSet<Integer>();
            sum[i] = i;
        }
    }

    // Implementation for Problem
    public void unionSet(int x, int y) { // O(1)
        if (isSameSet(x,y)) {
            return;
        } else {
            int newDon = findSet(y);
            int oldDon = findSet(x);
            capos[newDon].add(oldDon);
            capos[newDon].addAll(capos[oldDon]);
            p[oldDon] = newDon;
            capos[oldDon].clear();
            sum[newDon] += sum[oldDon];
        }
    }

    public void moveSet(int x, int y) { // O(n)
        if (isSameSet(x,y)) {
            return;
        } else {
            if (x == findSet(x)) { // x is don of set
                int newDon = findSet(y);
                capos[newDon].add(x);
                sum[newDon] += x;
                if (!capos[x].isEmpty()) {
                    Integer[] transfer = capos[x].toArray(new Integer[capos[x].size()]);
                    int replacementDon = transfer[0];
                    sum[replacementDon] = sum[x]-x;
                    sum[x] = x;
                    for (int i = 0; i < transfer.length; i++) {
                        p[transfer[i]] = replacementDon;
                        if (replacementDon != transfer[i]) {
                            capos[replacementDon].add(transfer[i]);
                        }
                    }
                }
                capos[x].clear();
                p[x] = newDon;
            } else { // x is a capo
                int newDon = findSet(y);
                int oldDon = findSet(x);
                capos[oldDon].remove(x);
                sum[oldDon] -= x;
                for (Integer capo: capos[oldDon]) {
                    p[capo] = oldDon;
                }
                capos[newDon].add(x);
                p[x] = newDon;
                sum[newDon] += x;
            }
        }
    }

    public long sumSet(int x) { // O(1) time
        return sum[findSet(x)];
    }

    public int setSize(int x) { // O(1) time
        return capos[findSet(x)].size() + 1;
    }

    // Useful additional functions
    public int findSet(int i) {
        if (p[i] == i) {
            return i;
        } else {
            return findSet(p[i]);
        }
    }

    public boolean isSameSet(int x, int y) {
        return (findSet(x) == findSet(y));
    }
}
