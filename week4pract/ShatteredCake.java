// Ang Ping Young (A0199498X)
// Kattis Best: 0.11s, My Timing: 0.96s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ShatteredCake {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        int width = Integer.parseInt(br.readLine());
        int pieces = Integer.parseInt(br.readLine());
        int area = 0;
        for (int i = 0; i < pieces; i++) {
            String[] line = br.readLine().split(" ");
            area += (Integer.parseInt(line[0]) * Integer.parseInt(line[1])); 
        }
        pw.println(area/width);
        pw.close();
    }
}