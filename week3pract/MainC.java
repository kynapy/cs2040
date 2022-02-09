// Ang Ping Young (A0199498X)
// Kattis Time: 0.20s, Best: 0.06s
import java.util.Scanner;

public class MainC {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int Zr = sc.nextInt();
        int Zc = sc.nextInt();
        for (int i = 0; i < rows; i++) {
            String input = sc.next();
            String result = "";
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < Zc; k++) {
                    result += String.valueOf(input.charAt(j));
                }
            }
            for (int j = 0; j < Zr; j++) {
                System.out.println(result);
            }
        }
    }
}