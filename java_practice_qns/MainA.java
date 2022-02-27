import java.util.Scanner;

public class MainA {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int length = name.length();
        String result = "" + name.charAt(0);
        for (int i = 0; i < length; i++) {
            if (name.charAt(i) == "-".charAt(0)) {
                result += name.charAt(i+1);
            }
        }
        System.out.println(result);
    }
}