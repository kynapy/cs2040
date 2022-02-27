// Kattis Best:0.06s, My Timing: 0.11s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class DelimiterSoup {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();
        boolean error = false;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < length; i++) {
            String character = String.valueOf(input.charAt(i));
            if (character.equals("(") || character.equals("[") || character.equals("{")) {
                stack.push(character);
            } 
            else if (character.equals(")")) {
                if (stack.empty()) {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
                else if (stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
            }
            else if (character.equals("}")) {
                if (stack.empty()) {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
                else if (stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
            }
            else if (character.equals("]")) {
                if (stack.empty()) {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
                else if (stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    pw.println(character + " " + i);
                    error = true;
                    break;
                }
            }
        }
        if (!error) {
            pw.println("ok so far");
        }
        pw.close();
    }
}