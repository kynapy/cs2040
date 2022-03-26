// Kattis ID: almostunionfind
// Time taken: 3.50s, Fastest time: 0.38s

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
                    numbers.unionSet(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                }
                else if (operation.equals("2")) {
                    numbers.moveSet(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
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
    public int size[];

    @SuppressWarnings("unchecked")
    UnionFind(int N) {
        p = new int[N];
        capos = new HashSet[N];
        sum = new long[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            capos[i] = new HashSet<Integer>();
            sum[i] = i;
            size[i] = 1;
        }
    }

    // Implementation for Problem
    public void unionSet(int x, int y) { // O(1) ish
        if (isSameSet(x,y)) {
            return;
        } else {
            int newDon = findSet(y);
            int oldDon = findSet(x);
            capos[y].add(oldDon);
            p[oldDon] = y;
            size[newDon] += size[oldDon];
            sum[newDon] += sum[oldDon];
        }
    }

    public void moveSet(int x, int y) { // O(n)
        if (isSameSet(x,y)) {
            return;
        } else {
            if (x == findSet(x)) { // x is don of set
                int newDon = findSet(y);
                sum[newDon] += x;
                size[newDon] += 1;
                capos[y].add(x);
                if (!capos[x].isEmpty()) {
                    Integer[] transfer = capos[x].toArray(new Integer[capos[x].size()]);
                    int replacementDon = transfer[0];
                    sum[replacementDon] = sum[x]-x;
                    sum[x] = x;
                    size[replacementDon] = size[x] - 1;
                    size[x] = 1;
                    for (int i = 0; i < transfer.length; i++) {
                        p[transfer[i]] = replacementDon;
                        if (replacementDon != transfer[i]) {
                            capos[replacementDon].add(transfer[i]);
                        }
                    }
                }
                capos[x] = new HashSet<Integer>();
                p[x] = y;
            } else { // x is a capo
                int newDon = findSet(y);
                int oldDon = findSet(x);
                int oneUp = p[x];
                capos[oneUp].remove(x);
                sum[oldDon] -= x;
                size[oldDon] -= 1;
                for (Integer capo: capos[x]) {
                    p[capo] = oneUp;
                    capos[oneUp].add(capo);
                }
                capos[x] = new HashSet<Integer>();
                capos[y].add(x);
                p[x] = y;
                sum[newDon] += x;
                size[newDon] += 1;
            }
        }
    }

    public long sumSet(int x) { // O(1) time
        return sum[findSet(x)];
    }

    public int setSize(int x) { // O(1) time-ish
        return size[findSet(x)];
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
