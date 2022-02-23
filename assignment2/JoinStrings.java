// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class JoinStrings {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        // Reading the string inputs
        int numOfInputs = Integer.parseInt(br.readLine());
        LinkedStrings inputs[] = new LinkedStrings[numOfInputs + 1];
        for (int i = 1; i < numOfInputs+1; i++) {
            LinkedStrings input = new LinkedStrings(br.readLine());
            inputs[i] = input;
        }

        // Linking up the strings
        int start = 1;
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < numOfInputs - 1; i++) {
            String[] input = br.readLine().split(" ");
            int front = Integer.parseInt(input[0]);
            int back = Integer.parseInt(input[1]);
            int frontCopy = front;
            if (mapping.containsKey(front)) {
                front = mapping.get(front);
                if (mapping.containsKey(back)) {
                    mapping.put(frontCopy, mapping.get(back));
                } else {
                    mapping.put(frontCopy, back);
                }
            } else {
                if (mapping.containsKey(back)) {
                    mapping.put(front, mapping.get(back));
                } else {
                    mapping.put(front, back);
                }
            }
            inputs[front].tail = inputs[back];
            if (i == (numOfInputs-2)) {
                start = frontCopy;
            }
        }

        // Joining everything together
        LinkedStrings pointer = inputs[start];
        for (int i = 0; i < numOfInputs; i++) {
            pw.print(pointer.words);
            pointer = pointer.tail;
        }
        pw.println();
        pw.close();
    }
}

class LinkedStrings {
    public final String words;
    public LinkedStrings tail;

    LinkedStrings(String words) {
        this.words = words;
        this.tail = null;
    }
}