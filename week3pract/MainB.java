// Kattis Time: 0.10s, Best: 0.06s
import java.util.Scanner;

public class MainB {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % x == 0 && i % y == 0) {
                System.out.println("FizzBuzz");
            } 
            else if (i % x == 0) {
                System.out.println("Fizz");
            }
            else if (i % y == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}