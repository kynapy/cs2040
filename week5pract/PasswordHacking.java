// Ang Ping Young (A0199498X)
// Kattis Best: 0.07s, My Timing: 0.08s 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class PasswordHacking {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code 
        int numOfLines = Integer.parseInt(br.readLine());
        Double[] probabilities = new Double[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            String[] test = br.readLine().split(" ");
            probabilities[i] = Double.parseDouble(test[1]);
        }
        Arrays.sort(probabilities, Collections.reverseOrder());
        double result = 0;
        for (int i = 0; i < numOfLines; i++) {
            result += ((i+1) * probabilities[i]);
        }
        pw.println(result);
        pw.close();
    }
}