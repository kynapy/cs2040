import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int restaurants = sc.nextInt();
        String result = "Anywhere is fine I guess";
        boolean found = false;

        for (int i = 0; i < restaurants; i++) {
            int itemsOnMenu = sc.nextInt();
            String x = sc.nextLine();
            String restaurantName = sc.nextLine();

            boolean pancakes = false;
            boolean peasoup = false;

            for (int j = 0; j < itemsOnMenu; j++) {
                String item = sc.nextLine();
                if (item.equals("pancakes")) {
                    pancakes = true;
                }
                if (item.equals("pea soup")) {
                    peasoup = true;
                }
                if (peasoup && pancakes) {
                    if (!found) {
                        result = restaurantName;
                        found = true;
                    }
                }
            }
        }
        System.out.println(result);
    }
}