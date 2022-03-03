// Kattis Best: 0.08s, My Timing: 0.19s  

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Conformity {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        int numOfFrosh = Integer.parseInt(br.readLine());
        HashMap<ArrayList<Integer>, Integer> allCombinations = new HashMap<ArrayList<Integer>, Integer>();
        for (int i = 0; i < numOfFrosh; i++) {
            String[] input = br.readLine().split(" ");
            ArrayList<Integer> courseCombination = new ArrayList<Integer>(); 
            for (int j = 0; j < 5; j++) {
                courseCombination.add(Integer.parseInt(input[j]));
            }
            Collections.sort(courseCombination);
            if (allCombinations.containsKey(courseCombination)) {
                allCombinations.put(courseCombination, allCombinations.get(courseCombination) + 1);
            } else {
                allCombinations.put(courseCombination, 1);
            }
        }
        int max = 0;
        for (Integer value : allCombinations.values()) {
            if (value > max) {
                max = value;
            }
        }
        int result = 0;
        for (Integer value : allCombinations.values()) {
            if (value == max) {
                result += value;
            }
        }
        pw.println(result);
        pw.close();
    }
}