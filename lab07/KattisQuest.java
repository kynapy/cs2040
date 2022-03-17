// Kattis Best: 0.37s, My Timing: 0.73s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class KattisQuest {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        long numCommands = Integer.parseInt(br.readLine());
        TreeSet<Quest> quests = new TreeSet<Quest>();
        int addCount = 0;
        for (int i = 0; i < numCommands; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("add")) {
                int energy = Integer.parseInt(command[1]);
                int gold = Integer.parseInt(command[2]);
                quests.add(new Quest(addCount, energy, gold));
                addCount++;
            } else {
                long totalGold = 0;
                int query = Integer.parseInt(command[1]);
                while (!quests.isEmpty()) {
                    Quest q = quests.floor(new Quest(10000000, query, 10000000));
                    if (q == null) {
                        break;
                    } else {
                        totalGold += q.goldReward;
                        query -= q.energyConsumption;
                        quests.remove(q);
                    }
                }
                pw.println(totalGold);
            }
        }
        pw.close();
    }
}

class Quest implements Comparable<Quest> {
    public final int id;
    public final int energyConsumption;
    public final int goldReward;

    Quest(int id, int energyConsumption, int goldReward) {
        this.id = id;
        this.energyConsumption = energyConsumption;
        this.goldReward = goldReward;
    }

    @Override
    public int compareTo(Quest other) {
        if (this.energyConsumption == other.energyConsumption) {
            if (this.goldReward == other.goldReward) {
                return this.id - other.id;
            } else {
                return this.goldReward - other.goldReward;
            }
        } else {
            return this.energyConsumption - other.energyConsumption;
        }
    }
}