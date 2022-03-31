// Kattis ID: workstations
// Time taken: 0.87s, Fastest time: 0.39s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Workstations {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        String[] input = br.readLine().split(" ");
        int numResearchers = Integer.parseInt(input[0]);
        int inactivity = Integer.parseInt(input[1]);
        
        // 2 PQs, one for Researchers, one for WorkStations
        PriorityQueue<Researcher> order = new PriorityQueue<Researcher>();
        PriorityQueue<WorkStation> stations = new PriorityQueue<WorkStation>();

        for (int i = 0; i < numResearchers; i++) {
            String[] researcherInput = br.readLine().split(" ");
            int arrivalTime = Integer.parseInt(researcherInput[0]);
            int workTime = Integer.parseInt(researcherInput[1]); 
            Researcher researcher = new Researcher(arrivalTime, workTime);
            order.add(researcher);
        }
        int unlocks = 0;
        while (!order.isEmpty()) {
            Researcher researcher = order.poll();
            int endTime = researcher.arrivalTime + researcher.workTime;
            int timeout = endTime + inactivity;
            boolean found = false;
            while (!found) {
                if (stations.isEmpty()) {
                    stations.add(new WorkStation(endTime, timeout));
                    unlocks += 1;
                    found = true;
                } else {
                    WorkStation station = stations.peek();
                    if (researcher.arrivalTime < station.nextAvailableTime) {
                        stations.add(new WorkStation(endTime, timeout));
                        unlocks += 1;
                        found = true;
                    }
                    else if (station.nextAvailableTime <= researcher.arrivalTime && researcher.arrivalTime <= station.expiringTime) {
                        stations.add(new WorkStation(endTime, timeout));
                        stations.remove();
                        found = true;
                    } else {
                        stations.remove();
                    }
                }
            }
        }
        pw.println(numResearchers - unlocks);
        pw.close();
    }
}

class Researcher implements Comparable<Researcher> {
    public final int arrivalTime;
    public final int workTime;

    Researcher(int arrivalTime, int workTime) {
        this.arrivalTime = arrivalTime;
        this.workTime = workTime;
    }

    @Override
    public int compareTo(Researcher other) {
        if (this.arrivalTime - other.arrivalTime == 0) {
            return this.workTime - other.workTime;
        } else {
            return this.arrivalTime - other.arrivalTime;
        }
    }
}

class WorkStation implements Comparable<WorkStation> {
    public final int nextAvailableTime;
    public final int expiringTime;

    WorkStation(int nextAvailableTime, int expiringTime) {
        this.nextAvailableTime = nextAvailableTime;
        this.expiringTime = expiringTime;
    }

    @Override
    public int compareTo(WorkStation other) {
        return this.expiringTime - other.expiringTime;
    }
}