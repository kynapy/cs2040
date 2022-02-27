// Kattis Time: 0.15s, Best: 0.06s
import java.util.Scanner;

public class MainA {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int length = name.length();
        String result = "";
        String prev = "";
        for (int i = 0; i < length; i++) {
            String curr = String.valueOf(name.charAt(i));
            if (!prev.equals(curr)) {
                result += curr;
            }
            prev = curr;
        }
        System.out.println(result);
    }
}