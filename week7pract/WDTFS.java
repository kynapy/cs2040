// Kattis ID: whatdoesthefoxsay
// Kattis Best: 0.06s, My Timing: 0.11s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WDTFS {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        int numCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCases; i++) {
            String recording[] = br.readLine().split(" ");
            ArrayList<String> transcript = new ArrayList<String>(Arrays.asList(recording));
            while (true) {
                String sounds = br.readLine();
                if (sounds.equals("what does the fox say?")) {
                    break;
                } else {
                    String animalSound = sounds.split(" ")[2];
                    while (transcript.contains(animalSound)) {
                        transcript.remove(animalSound);
                    }
                }
            }
            for (int j = 0; j < transcript.size(); j++) {
                pw.print(transcript.get(j) + " ");
            }
            pw.println();
        }
        pw.close();
    }
}