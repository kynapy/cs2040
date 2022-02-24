// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Teque {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code (Done)
        int numOfCommands = Integer.parseInt(br.readLine());
        TequeImplt teque = new TequeImplt();
        for (int i = 0; i < numOfCommands; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int x = Integer.parseInt(input[1]);
            if (command.equals("push_back")) {
                TequeNode newNode = new TequeNode(x);
                teque.pushBack(newNode);
            }
            else if (command.equals("push_front")) {
                TequeNode newNode = new TequeNode(x);
                teque.pushFront(newNode);
            } 
            else if (command.equals("push_middle")) {
                TequeNode newNode = new TequeNode(x);
                teque.pushMiddle(newNode);
            } else {
                pw.println(teque.get(x).getElement());
            }
        }
        pw.close();
    }
}

class TequeImplt {
    public int weight;
    public int size;
    public TequeNode head;
    public TequeNode tail;
    public TequeNode middle;

    TequeImplt() {
        this.weight = 0;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.middle = null;
    }

    public void pushFront(TequeNode newNode) {
        if (size == 0) {
            head = newNode;
            tail = newNode;
            middle = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            if (weight == 1) {
                weight = 0;
                middle = middle.getPrev();
            } else {
                weight++;
            }
        }
        size++;
    }

    public void pushBack(TequeNode newNode) {
        if (size == 0) {
            head = newNode;
            tail = newNode;
            middle = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            if (weight == -1) {
                weight = 0;
                middle = middle.getNext();
            } else {
                weight--;
            }
        }
        size++;
    }

    public void pushMiddle(TequeNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            middle = newNode;
        } else {

        }
        size++;
    }

    public TequeNode get(int index) { // Done lazily
        if (size == 0) {
            return null;
        }
        else if (index == size-1) {
            return tail;
        } else { // Lazy solution, haven't optimise
            TequeNode trav = head;
            for (int i = 0; i < index; i++) {
                trav = trav.getNext();
            }
            return trav;
        }
    }
}

class TequeNode { // Done
    public int element;
    public TequeNode prev;
    public TequeNode next;

    TequeNode(int element) {
        this(element, null, null);
    }

    TequeNode(int element, TequeNode prev, TequeNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public TequeNode getPrev() {
        return prev;
    }

    public TequeNode getNext() {
        return next;
    }

    public int getElement() {
        return element;
    }

    public void setPrev(TequeNode prev) {
        this.prev = prev;
    }

    public void setNext(TequeNode next) {
        this.next = next;
    }
}