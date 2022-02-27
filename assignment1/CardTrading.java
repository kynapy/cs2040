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
        String[] firstLine = br.readLine().split(" ");
        int numAnthonyCards = Integer.parseInt(firstLine[0]);
        int typesOfCards = Integer.parseInt(firstLine[1]);
        int requiredCombos = Integer.parseInt(firstLine[2]);

        // Stores Anthony's cards in an array
        String[] cardsOwned = br.readLine().split(" ");

        // Counts the number of cards Anthony has and stores the data in a DAT (Correct)
        int[] cardsPerType = new int[typesOfCards+1];
        for (int i = 0; i < numAnthonyCards; i++) {
            int number = Integer.parseInt(cardsOwned[i]);
            cardsPerType[number]+=1;
        }

        // Calculate the cost of getting a combo for each card and sort them by the cost (Correct)
        ArrayList<Card> cardCost = new ArrayList<Card>();
        for (int i = 1; i <= typesOfCards; i++) {
            String[] prices = br.readLine().split(" ");
            long buyPrice = Long.parseLong(prices[0]);
            long sellPrice = Long.parseLong(prices[1]);
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
            cardCost.add(new Card(i, buyPrice, sellPrice, cost));
        }
        Collections.sort(cardCost);

        // Selling and buying cards
        long result = 0;
        for (int i = 0; i < typesOfCards; i++) {
            Card card = cardCost.get(i);
            if (i < requiredCombos) { // Buy
                result -= (2 - cardsPerType[card.value]) * card.buyPrice;
            } else { // Sell
                result += cardsPerType[card.value] * card.sellPrice;
            }
        }

        // Printing result
        pw.println(result);

        // Close PrintWriter, end of program
        pw.close();
    }
}

class Card implements Comparable<Card> {
    public final int value;
    public final long buyPrice;
    public final long sellPrice;
    public final long costOfOwning;

    Card(int value, long buyPrice, long sellPrice, long costOfOwning) {
        this.value = value;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.costOfOwning = costOfOwning;
    }

    @Override
    public int compareTo(Card other) {
        long x = this.costOfOwning - other.costOfOwning;
        if (x < 0) {
            return -1;
        } 
        else if (x > 0) {
            return 1;    
        } else {
            return 0;
        }
    }
}