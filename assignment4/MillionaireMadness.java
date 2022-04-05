import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class MillionaireMadness {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        String firstLine[] = br.readLine().split(" ");
        int length = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        for (int i = 0; i < length; i++) {
            
        }
        pw.close();
    }
}