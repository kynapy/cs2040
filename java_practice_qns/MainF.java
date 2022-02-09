// Ang Ping Young (A0199498X)

import java.util.Scanner;

public class MainF {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int result = 0;
        for (int i = 0; i < numbers; i++) {
            int number = sc.nextInt();
            result += Math.pow(number / 10, number % 10);
        }
        System.out.println(result);
    }
}