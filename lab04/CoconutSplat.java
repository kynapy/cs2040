// Kattis Best: 0.06s, My Timing: 0.07s  

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class CoconutSplat {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Main code
        String[] input = br.readLine().split(" ");
        int syllables = Integer.parseInt(input[0]);
        int numPlayers = Integer.parseInt(input[1]);
        LinkedList<Player> playerqueue = new LinkedList<Player>();
        for (int i = 1; i <= numPlayers; i++) {
            playerqueue.addLast(new Player(i, 2));
        }
        while (playerqueue.size() != 1) {
            int count = syllables;
            while (count > playerqueue.size()) {
                count-=playerqueue.size();
            }
            for (int i = 1; i < syllables; i++) {
                Player p = playerqueue.remove();
                playerqueue.addLast(p);
            }
            Player chosen = playerqueue.remove();
            if (chosen.status == 2) {
                playerqueue.addFirst(new Player(chosen.playerNum, 1));
                playerqueue.addFirst(new Player(chosen.playerNum, 1));
            } 
            else if (chosen.status == 1) {
                playerqueue.addLast(new Player(chosen.playerNum, 0));
            }
        }
        pw.println(playerqueue.remove().playerNum);
        pw.close();
    }
}


class Player {
    public int playerNum; 
    public int status;

    Player(int playerNum, int status) {
        this.playerNum = playerNum;
        this.status = status;
    } 
}