import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Dominos {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        // Number of test cases
        int numInputs = Integer.parseInt(br.readLine());
        for (int i = 0; i < numInputs; i++) {
            int result = 1;
            String input[] = br.readLine().split(" ");
            int numTiles = Integer.parseInt(input[0]); // The number of tiles from 1 to n
            int numLines = Integer.parseInt(input[1]); // The number of lines indicating domino effect
            ArrayList edgeList[] = new ArrayList[numTiles];

            // Each line indicates if dominoX falls, dominoY falls
            for (int j = 0; j < numLines; j++) {
                String line[] = br.readLine().split(" ");
                int dominoX = Integer.parseInt(line[0]);
                int dominoY = Integer.parseInt(line[1]);
                if (edgeList[dominoX] == null) {
                    edgeList[dominoX] = new ArrayList<Integer>();
                }
                edgeList[dominoX].add(dominoY);
            }
            pw.println(result);
        }
        pw.close();
    }
}