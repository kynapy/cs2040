// Ang Ping Young (A0199498X)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

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
                teque.pushBack(new TequeNode(x));
            }
            else if (command.equals("push_front")) {
                teque.pushFront(new TequeNode(x));
            } 
            else if (command.equals("push_middle")) {
                teque.pushMiddle(new TequeNode(x));
            } else {
                pw.println(teque.get(x).element);
            }
        }
        pw.close();
    }
}

class TequeImplt {
    public int size;
    public int middle_index;
    public TequeNode head;
    public TequeNode tail;
    public TequeNode middle;

    TequeImplt() {
        this.size = 0;
        this.middle_index = 0;
        this.head = null;
        this.tail = null;
        this.middle = null;
    }

    public void pushFront(TequeNode newNode) {
        if (size == 0) {
            head = newNode;
            middle = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            size++;
            middle_index++;
            while (middle_index - (size - middle_index) > 1) {
                middle = middle.getPrev();
                middle_index--;
            }
        }
    }

    public void pushBack(TequeNode newNode) {
        if (size == 0) {
            pushFront(newNode);
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;
            middle = this.get(size / 2);
            middle_index = size / 2;
        }
    }

    public void pushMiddle(TequeNode newNode) {
        if (size == 0) {
            pushFront(newNode);
        }
        else if (size == 1) {
            pushBack(newNode);
        } else {
            TequeNode ahead = this.get((size+1)/2 - 1);
            TequeNode after = ahead.getNext();
            newNode.setPrev(ahead);
            ahead.setNext(newNode);
            newNode.setNext(after);
            after.setPrev(newNode);
            size++;
            middle_index = size/2;
            middle = newNode;
        }
    }

    public TequeNode get(int index) {
        if (size == middle_index) {
            return middle;
        } 
        else if (index < middle_index) {
            if (middle_index / 2 >= index) {
                int steps = middle_index - index;
                TequeNode trav = middle;
                while (steps != 0) {
                    trav = trav.getPrev();
                    steps--;
                }
                return trav;
            } else {
                TequeNode trav = head;
                for (int i = 0; i < index; i++) {
                    trav = trav.getNext();
                }
                return trav;
            }
        }
        else {
            if ((size-1+middle_index)/2 > index) {
                int steps = index - middle_index;
                TequeNode trav = middle;
                while (steps != 0) {
                    trav = trav.getNext();
                    steps--;
                }
                return trav;
            }
            else {
                int position = size - 1;
                TequeNode trav = tail;
                while (position != index) {
                    trav = trav.getPrev();
                    position--;
                }
                return trav;
            }
        }
    }
}

class TequeNode { // Done
    public int element;
    public TequeNode prev;
    public TequeNode next;

    TequeNode(int element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public TequeNode getPrev() {
        return prev;
    }

    public TequeNode getNext() {
        return next;
    }

    public void setPrev(TequeNode prev) {
        this.prev = prev;
    }

    public void setNext(TequeNode next) {
        this.next = next;
    }
}