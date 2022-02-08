// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class CardTrading {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] requirements = br.readLine().split(" ");
        String[] anthonysCards = br.readLine().split(" ");
        Arrays.sort(anthonysCards);
        int numberOfCards = Integer.parseInt(requirements[0]);
        int typesOfCards = Integer.parseInt(requirements[1]);
        ArrayList<Card> cards = new ArrayList<Card>();

        // Adds the types of carry to ArrayList cards, can be accessed by indexing
        for (int i = 1; i <= typesOfCards; i++) {
            String[] card = br.readLine().split(" ");
            cards.add(new Card(i, Integer.parseInt(card[0]), Integer.parseInt(card[1]))); 
        }

        // Testing 
        for (int i = 0; i < numberOfCards; i++) {
            pw.println(anthonysCards[i]);
        }
        for (int i = 0; i < typesOfCards; i++) {
            pw.println(cards.get(i));
        }
        pw.close();
    }
}

class Card {
    private final int number;
    private final int buyPrice;
    private final int sellPrice;

    Card(int number, int buyPrice, int sellPrice) {
        this.number = number;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return String.format("Card %d, buying at %d, selling at %d", number, buyPrice, sellPrice);
    }
}