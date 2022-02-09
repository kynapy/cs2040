// Ang Ping Young (A0199498X)

import java.util.Scanner;

public class MainD {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int[] result = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            int number = sc.nextInt();
            number = factorial(number);
            result[i] = number % 10;
        }
        for (int i = 0; i < numbers; i++) {
            System.out.println(result[i]);
        }
    }

    static int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}