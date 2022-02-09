// Ang Ping Young (A0199498X)

import java.util.Scanner;

public class MainG {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] result = new String[number];
        for (int i = 0; i < number; i++) {
            String a = sc.next();
            String b = sc.next();
            String comparison = "";
            int length = a.length();
            for (int j = 0; j < length; j++) {
                if (a.charAt(j) == b.charAt(j)) {
                    comparison += ".";
                } else {
                    comparison += "*";
                }
            }
            result[i] = a + "\n" + b + "\n" + comparison + "\n";
        }
        for (int i = 0; i < number; i++) {
            System.out.println(result[i]);
        }
    }
}