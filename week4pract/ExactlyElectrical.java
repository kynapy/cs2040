// Ang Ping Young (A0199498X)
// Kattis Best: 0.06s, My Timing: 0.06s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ExactlyElectrical {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] target = br.readLine().split(" ");
        String[] current = br.readLine().split(" ");
        int distance = Integer.parseInt(br.readLine());

        int xDistance = Integer.parseInt(target[0]) - Integer.parseInt(current[0]);
        int yDistance = Integer.parseInt(target[1]) - Integer.parseInt(current[1]);
        if (xDistance < 0) {
            xDistance*=-1;
        }
        if (yDistance < 0) {
            yDistance*=-1;
        }
        distance = distance - xDistance - yDistance;
        if (distance >= 0 && distance % 2 == 0) {
            pw.println("Y");
        } else {
            pw.println("N");
        }
        pw.close();
    }
}