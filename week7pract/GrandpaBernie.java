// Kattis ID: grandpabernie
// Kattis Best: 0.49s, My Timing: 0.62s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class GrandpaBernie {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        HashMap<String, ArrayList<Integer>> trips = new HashMap<String, ArrayList<Integer>>();
        int numTrips = Integer.parseInt(br.readLine());
        for (int i = 0; i < numTrips; i++) {
            String[] trip = br.readLine().split(" ");
            String country = trip[0];
            int year = Integer.parseInt(trip[1]);
            if (trips.containsKey(country)) {
                trips.get(country).add(year);
            } else {
                ArrayList<Integer> yearsOfTrip = new ArrayList<Integer>();
                yearsOfTrip.add(year);
                trips.put(country, yearsOfTrip);
            }
        }
        for (ArrayList<Integer> yearList : trips.values()) {
            Collections.sort(yearList);
        }
        int numQueries = Integer.parseInt(br.readLine());
        for (int i = 0; i < numQueries; i++) {
            String[] query = br.readLine().split(" ");
            String country = query[0];
            int k = Integer.parseInt(query[1]) - 1;
            pw.println(trips.get(country).get(k));
        }
        pw.close();
    }
}