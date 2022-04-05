// Kattis ID: islands3
// Time taken: 0.08s, Fastest time: 0.06s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Islands {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        while (true) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.equals("")) {
                break;
            }
            String[] rowsAndColumns = firstLine.split(" ");
            int rows = Integer.parseInt(rowsAndColumns[0]);
            int columns = Integer.parseInt(rowsAndColumns[1]);
            String[][] image = new String[rows][columns];
            for (int i = 0; i < rows; i++) {
                image[i] = br.readLine().split("");
            }
            int[][] visited = new int[rows][columns];
            LinkedList<Pair> nearbyLands = new LinkedList<Pair>();
            int islands = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (image[i][j].equals("L") && visited[i][j] == 0)  {
                        nearbyLands.add(new Pair(i,j));
                        visited[i][j] = 1;
                        //pw.print(i + " ");
                        //pw.println(j);
                        islands += 1;
                    }
                    while (!nearbyLands.isEmpty()) {
                        Pair possibleLand = nearbyLands.removeFirst();
                        int x = possibleLand.first;
                        int y = possibleLand.second;
                        if (x + 1 < rows && visited[x+1][y] == 0) {
                            if (!image[x+1][y].equals("W")) {
                                nearbyLands.add(new Pair(x+1, y));
                                visited[x+1][y] = 1;
                            } 
                        }
                        if (x - 1 >= 0 && visited[x-1][y] == 0) {
                            if (!image[x-1][y].equals("W")) {
                                nearbyLands.add(new Pair(x-1, y));
                                visited[x-1][y] = 1;
                            } 
                        }
                        if (y + 1 < columns && visited[x][y+1] == 0) {
                            if (!image[x][y+1].equals("W")) {
                                nearbyLands.add(new Pair(x, y+1));
                                visited[x][y+1] = 1;
                            } 
                        }
                        if (y - 1 >= 0 && visited[x][y-1] == 0) {
                            if (!image[x][y-1].equals("W")) {
                                nearbyLands.add(new Pair(x, y-1));
                                visited[x][y-1] = 1;
                            } 
                        }
                    }
                }
            }
            pw.println(islands);
        }
        pw.close();
    }
}

class Pair {
    public int first;
    public int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}