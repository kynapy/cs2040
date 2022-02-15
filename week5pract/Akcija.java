// Ang Ping Young (A0199498X)
// Kattis Best: 0.08s, My Timing: 0.33s 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Akcija {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        int numOfLines = Integer.parseInt(br.readLine());
        //ArrayList<Integer> books = new ArrayList<Integer>();
        Integer[] books = new Integer[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(books, Collections.reverseOrder());
        int price = 0;
        for (int i = 0; i < numOfLines; i++) {
            if ((i+1) % 3 != 0) {
                price += books[i];
            }
        }
        pw.println(price);
        pw.close();
    }
}