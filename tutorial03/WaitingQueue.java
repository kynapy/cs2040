// Question 3 of Tutorial

import java.util.*;

class WaitingQueue {
    public String[] arr;
    public int queueSize;
    public int maxSize;
    public int front, back;

    WaitingQueue(int size) {
        arr = new String[size];
        this.maxSize = size;
        front = 0;
        back = 0;
        queueSize = 0;
    }

    public boolean isEmpty() {
        if (queueSize == 0) { return true; } 
        else { return false; }
    }

    public void enqueue(String name) {
        if (queueSize == maxSize) {
            System.out.println("Queue is full");
            return;
        }
        arr[back] = name;
        back = (back + 1) % maxSize;
        queueSize += 1;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String person = arr[front];
        front = (front + 1) % maxSize;
        queueSize -= 1;
        return person; 
    }

    public void leave(String name) {
        if (isEmpty()) {
            return;
        }
        int position = -1;
        for (int i = 0; i < maxSize; i++) {
            if (arr[i] == name) {
                position = i;
            }
        }
        if (position >= 0) {
            while ((position % maxSize) != back) {
                arr[position] = arr[position+1];
                position += 1;
            }
            back = (back - 1) % maxSize;
            queueSize -= 1;
        }
    }

    public void print() {
        String result = "";
        int trav = front;
        while (trav != back) {
            result += arr[trav];
            result += " ";
            trav += 1;
            if (trav >= maxSize) {
                trav = 0;
            }
        }
        System.out.println(result);
    }
}