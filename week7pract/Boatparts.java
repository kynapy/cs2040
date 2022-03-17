// Kattis Best:0.06s, My Timing: 0.07s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Boatparts {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Main code
        String[] firstLine = br.readLine().split(" ");
        int numParts = Integer.parseInt(firstLine[0]);
        int numDays = Integer.parseInt(firstLine[1]);
        HashSet<String> partsReplaced = new HashSet<String>();
        boolean found = false;
        for (int i = 0; i < numDays; i++) {
            partsReplaced.add(br.readLine());
            if (partsReplaced.size() == numParts) {
                System.out.println(i+1);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("paradox avoided");
        }
    }
}