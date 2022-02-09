// Ang Ping Young (A0199498X)
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String arg[]) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "2");
        map.put("b", "22");
        map.put("c", "222");
        map.put("d", "3");
        map.put("e", "33");
        map.put("f", "333");
        map.put("g", "4");
        map.put("h", "44");
        map.put("i", "444");
        map.put("j", "5");
        map.put("k", "55");
        map.put("l", "555");
        map.put("m", "6");
        map.put("n", "66");
        map.put("o", "666");
        map.put("p", "7");
        map.put("q", "77");
        map.put("r", "777");
        map.put("s", "7777");
        map.put("t", "8");
        map.put("u", "88");
        map.put("v", "888");
        map.put("w", "9");
        map.put("x", "99");
        map.put("y", "999");
        map.put("z", "9999");
        map.put(" ", "0");
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = sc.nextInt();
        String[] results = new String[numberOfInputs];
        String n = sc.nextLine();
        for (int i = 0; i < numberOfInputs; i++) {
            String result = "Case #" + (i+1) + ": ";
            String word = sc.nextLine();
            int length = word.length();
            for (int j = 0; j < length; j++) {
                String number = map.get(String.valueOf(word.charAt(j)));
                int resultLength = result.length();
                if (resultLength != 0) {
                    if (number.charAt(0) == result.charAt(resultLength-1)) {
                        result += " ";
                    }
                }
                result += number;
            }
            results[i] = result;
        }
        for (int i = 0; i < numberOfInputs; i++) {
            System.out.println(results[i]);
        }
    }
}