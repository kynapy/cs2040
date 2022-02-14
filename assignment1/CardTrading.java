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
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // First line of inputs
        String[] requirements = br.readLine().split(" ");
        int numberOfCards = Integer.parseInt(requirements[0]);
        int typesOfCards = Integer.parseInt(requirements[1]);
        int requiredCombos = Integer.parseInt(requirements[2]);

        // Stores Anthony's cards in an array
        String[] cardsOwned = br.readLine().split(" ");

        // Adds the types of cards to ArrayList cards, can be accessed by indexing  by (value - 1)
        ArrayList<Pair> possibleCards = new ArrayList<Pair>();
        for (int i = 0; i < typesOfCards; i++) {
            String[] card = br.readLine().split(" ");
            possibleCards.add(new Pair(Long.parseLong(card[0]), Long.parseLong(card[1])));
        }

        // Counts the number of cards Anthony has and stores the data in a DAT
        int[] cardsPerType = new int[typesOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            int number = Integer.parseInt(cardsOwned[i]);
            cardsPerType[number-1]+=1;
        }

        // Calculate the cost of getting a combo for each card and sort them by the cost
        ArrayList<Card> cardCost = new ArrayList<Card>();
        for (int i = 0; i < typesOfCards; i++) {
            long buyPrice = possibleCards.get(i).buyPrice;
            long sellPrice = possibleCards.get(i).sellPrice;
            int ownedCopies = cardsPerType[i];
            long cost = 0;
            if (ownedCopies == 0) {
                cost = 2 * buyPrice;
            } 
            else if (ownedCopies == 1) {
                cost = buyPrice + sellPrice;
            } else {
                cost = 2 * sellPrice;
            }
            cardCost.add(new Card(i+1, cost));
        }
        Collections.sort(cardCost);

        // Calculate profit/loss
        long result = 0;
        

        // Testing 
        for (int i=0; i<typesOfCards; i++) {
            System.out.println(cardCost.get(i).cost + " " + cardCost.get(i).value);
        }

        // Close PrintWriter, end of program
        pw.close();
    }
}

class Pair {
    public final long buyPrice;
    public final long sellPrice;

    Pair(long buyPrice, long sellPrice) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return String.format("Buying at %d, selling at %d", buyPrice, sellPrice);
    }
}

class Card implements Comparable<Card> {
    public final int value;
    public final long cost;

    Card(int value, long cost) {
        this.value = value;
        this.cost = cost;
    }

    @Override
    public int compareTo(Card other) {
        long x = this.cost - other.cost;
        if (x < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}