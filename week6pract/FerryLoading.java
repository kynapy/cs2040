// Kattis: Ferry Loading IV
// Best: 0.10s, My Timing: 0.20s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class FerryLoading {
    public static void main(String arg[]) throws Exception {
        // Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        int numOfCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCases; i++) {
            // Data and structures required
            String[] details = br.readLine().split(" ");
            int ferryLength = Integer.parseInt(details[0]) * 100; // in cm
            int numOfCars = Integer.parseInt(details[1]);
            LinkedList<Integer> left = new LinkedList<Integer>();
            LinkedList<Integer> right = new LinkedList<Integer>();

            // Parsing inputs
            for (int j = 0; j < numOfCars; j++) {
                String[] car = br.readLine().split(" ");
                if (car[1].equals("left")) {
                    left.offer(Integer.parseInt(car[0]));
                } else {
                    right.offer(Integer.parseInt(car[0]));
                }
            }

            // Additional stuff
            int result = 0;
            boolean ferryAtLeft = true;
            
            // Running the ferry
            while ((left.peekFirst() != null) || (right.peekFirst() != null)) {
                if (ferryAtLeft) {
                    int totalLength = 0;
                    while ((left.peekFirst() != null) && (totalLength + left.peekFirst() < ferryLength)) {
                        totalLength += left.pop();
                    }
                    result++;
                    ferryAtLeft = false;
                } else {
                    int totalLength = 0;
                    while ((right.peekFirst() != null) && (totalLength + right.peekFirst() < ferryLength)) {
                        totalLength += right.pop();
                    }
                    result++;
                    ferryAtLeft = true;
                }
            }
            pw.println(result);
        }
        pw.close();
    }
}