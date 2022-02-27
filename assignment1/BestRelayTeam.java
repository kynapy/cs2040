import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BestRelayTeam {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numOfRunners = Integer.parseInt(br.readLine());
        ArrayList<Runner> runners = new ArrayList<Runner>();

        // Adding runners into an ArrayList of runners
        for (int i = 0; i < numOfRunners; i++) {
            String[] details = (br.readLine()).split(" ");
            Runner runner = new Runner(details[0], Double.parseDouble(details[1]), Double.parseDouble(details[2]));
            runners.add(runner);
        }

        // Sort runners by speed of other leg
        Collections.sort(runners);

        // Recording the fastest speed here, starting with the first runner
        double fastest = runners.get(0).getFirst() + runners.get(1).getOther() + runners.get(2).getOther() + runners.get(3).getOther();
        int[] result = new int[4];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        // Making every runner the first lap runner, along with the 3 other fastest non-first lap runners
        for (int i = 1; i < numOfRunners; i++) {
            int added = 0;
            int currentRunner = 0;
            double speed = runners.get(i).getFirst();
            int[] currentRunners = new int[4];
            currentRunners[0] = i;
            while (added < 3) {
                if (currentRunner != i) {
                    speed += runners.get(currentRunner).getOther();
                    currentRunners[added+1] = currentRunner;
                    added += 1;   
                }
                currentRunner += 1;
            }
            if (speed < fastest) {
                fastest = speed;
                result = currentRunners;
            } 
        }

        // Prints out the speed
        pw.println(String.valueOf(fastest));
        
        // Prints out the runners
        for (int i = 0; i < 4; i++) {
            int placing = result[i];
            pw.println(runners.get(placing).getName());
        }
        pw.close();
    }
}

class Runner implements Comparable<Runner> {
    private final String name;
    private final double firstLeg;
    private final double otherLeg;

    Runner(String name, double firstLeg, double otherLeg) {
        this.name = name;
        this.firstLeg = firstLeg;
        this.otherLeg = otherLeg;
    }

    String getName() {
        return name;
    }

    double getFirst() {
        return firstLeg;
    }

    double getOther() {
        return otherLeg;
    }

    @Override
    public int compareTo(Runner other) {
        double result = this.otherLeg - other.otherLeg;
        if (result < 0) {
            return -1;
        }
        else if (result > 0) {
            return 1;
        } else { return 0; }
    }
}