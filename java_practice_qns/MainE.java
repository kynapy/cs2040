// Ang Ping Young (A0199498X)

import java.util.Scanner;

public class MainE {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        String[] result = new String[testcases];

        for (int i = 0; i < testcases; i++) {
            result[i] = "Impossible";
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            if (a + b == c) {
                result[i] = "Possible";
            } else if (a * b == c) {
                result[i] = "Possible";
            } else if (a - b == c || b - a == c) {
                result[i] = "Possible";
            } else if (a/b == c || b/a == c) {
                result[i] = "Possible";
            }
        }
        for (int i = 0; i < testcases; i++) {
            System.out.println(result[i]);
        }
    }
}