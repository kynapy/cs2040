import java.util.Scanner;

public class MainB {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() % 2 == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }
}