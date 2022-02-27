import java.util.Scanner;

public class MainC {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int chants = sc.nextInt();
        for (int i = 1; i <= chants; i++ ) {
            System.out.println(i + " Abracadabra");
        }
    }
}