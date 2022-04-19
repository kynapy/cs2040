// Kattis ID: guessthedatastructure
// Kattis Best: 0.15s, My Timing: 0.24s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;

public class GuessStructure {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        while(true) {
            String input = br.readLine();
            // EOF reached
            if (input == null) {
                break;
            } else {
                int numLines = Integer.parseInt(input);
                Stack<Integer> stack = new Stack<Integer>();
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
                LinkedList<Integer> queue = new LinkedList<Integer>();
                boolean s = true;
                boolean p = true;
                boolean q = true;
                for (int line = 0; line < numLines; line++) {
                    String command[] = br.readLine().split(" ");
                    if (command[0].equals("1")) { // Throw element in
                        int item = Integer.parseInt(command[1]);
                        stack.push(item);
                        pq.offer(item);
                        queue.offer(item);
                    } else { // Take out element
                        int item = Integer.parseInt(command[1]);
                        if (stack.empty() || stack.pop() != item) {
                            s = false;
                        }  
                        if (pq.isEmpty() || pq.poll() != item) {
                            p = false;
                        }
                        if (queue.isEmpty() || queue.poll() != item) {
                            q = false;
                        }
                    }
                }
                if (s && p && q || p && q || s && q || p && s) {
                    pw.println("not sure");
                }
                else if (p) {
                    pw.println("priority queue");
                } 
                else if (q) {
                    pw.println("queue");
                }
                else if (s) {
                    pw.println("stack");
                } else {
                    pw.println("impossible");
                }
            }
        }
        pw.close();
    }
}