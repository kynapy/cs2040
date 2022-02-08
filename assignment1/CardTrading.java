// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CardTrading {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        pw.close();
    }
}

class Card {
    private final int number;
    private final int sellPrice;
    private final int buyPrice;

    Card(int number, int sellPrice, int buyPrice) {
        this.number = number;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
    }
}