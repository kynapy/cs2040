// Ang Ping Young (A0199498X)
// Kattis Best: 0.09s, My Timing: 0.28s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class SumKindOfProblem {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        int numOfLines = Integer.parseInt(br.readLine());
        for (int i = 1; i <= numOfLines; i++) {
            int n = Integer.parseInt(br.readLine().split(" ")[1]);
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" ");
            sb.append(integerSum(n)).append(" ");
            int sum = oddSum(n);
            sb.append(sum).append(" ");
            sb.append(sum+n);
            pw.println(sb);
        }
        pw.close();
    }

    static int integerSum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result+=i;
        }
        return result;
    }

    static int oddSum(int n) {
        int result = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            result+=count;
            count+=2;
        }
        return result;
    }
}