// Ang Ping Young (A0199498X)
// Kattis Best: 0., My Timing: 0. 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Classy {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code

        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            lastLine.append("=");
        }
        pw.println(lastLine);
        pw.close();
    }
}
        