// Kattis: Integer Lists
// Best: 0.22s, My Timing: 0.39s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class IntegerLists {
    public static void main(String arg[]) throws Exception {
        // Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Main code
        int numOfCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCases; i++) {
            String instructions = br.readLine();
            int listSize = Integer.parseInt(br.readLine());
            String list = br.readLine();

            // Adding the elements into an array
            list = list.substring(1, list.length() - 1); // Removing the front and back brackets
            String[] elements = list.split(",");

            // Executing instructions
            boolean reversed = false;
            int front = 0;
            int back = listSize - 1;

            int instructionLength = instructions.length();
            for (int j = 0; j < instructionLength; j++) {
                char instruction = instructions.charAt(j);
                if (instruction == 'R') {
                    reversed = !reversed;
                }
                else {
                    if (!reversed) {
                        front++;
                    } else {
                        back--;
                    }
                }
            }

            // Printing out result
            if (front - 1 == back) {
                pw.println("[]");
            }
            else if (front -1 > back) {
                pw.println("error");
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (!reversed) {
                    for (int trav = front; trav < back; trav++) {
                        sb.append(elements[trav]);
                        sb.append(",");
                    }
                    sb.append(elements[back]);
                } else {
                    for (int trav = back; trav > front; trav--) {
                        sb.append(elements[trav]);
                        sb.append(",");
                    }
                    sb.append(elements[front]);
                }
                sb.append("]");
                pw.println(sb);
            }
        }
        pw.close();
    }
}

