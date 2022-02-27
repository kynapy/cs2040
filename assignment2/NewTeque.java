import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class NewTeque {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        int numOfCommands = Integer.parseInt(br.readLine());
        NewTequeImplt teque = new NewTequeImplt(1000000);
        for (int i = 0; i < numOfCommands; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int x = Integer.parseInt(input[1]);
            if (command.equals("push_back")) {
                teque.push_back(x);
            }
            else if (command.equals("push_front")) {
                teque.push_front(x);
            } 
            else if (command.equals("push_middle")) {
                teque.push_middle(x);
            } else {
                pw.println(teque.get(x));
                //pw.print(" ");
            }
        }
        /* EASIER CHECKING OF RESULTS
        pw.println();
        pw.println();
        pw.println("##### Array elements #####");
        for (int i = 0; i < 30; i++) {
            pw.print(teque.front[i]);
            pw.print(" ");
        }
        pw.println();
        for (int i = 0; i < 30; i++) {
            pw.print(teque.back[i]);
            pw.print(" ");
        }
        pw.println();*/
        pw.close();
    }
}

class NewTequeImplt {
    public int[] front;
    public int[] back;
    public int start;
    public int frontMid;
    public int backMid;
    public int end;
    public int size;

    NewTequeImplt(int arraySize) {
        this.front = new int[arraySize];
        this.back = new int[arraySize];
        this.frontMid = arraySize / 2;
        this.start = frontMid - 1;
        this.end = arraySize / 2;
        this.backMid = end - 1;
        this.size = arraySize;
    }

    public void push_front(int input) {
        front[start] = input;
        start--;
        int frontSize = frontMid - start;
        int backSize = end - backMid;
        if (frontSize - backSize > 1) {
            frontMid--;
            back[backMid] = front[frontMid];
            backMid--;
            front[frontMid] = 0;
        }
    }

    public void push_back(int input) {
        back[end] = input;
        end++;
        int frontSize = frontMid - start - 1;
        int backSize = end - backMid - 1;
        if (backSize > frontSize) {
            backMid++;
            front[frontMid] = back[backMid];
            frontMid++;
            back[backMid] = 0;
        }
    }

    public void push_middle(int input) {
        int frontSize = frontMid - start - 1;
        int backSize = end - backMid - 1;
        if (frontSize <= backSize) {
            front[frontMid] = input;
            frontMid++;
        } else {
            back[backMid] = input;
            backMid--;
        }
    }

    public int get(int index) { // (DONE)
        int frontSize = frontMid - start - 1;
        if (index + 1 <= frontSize) {
            return front[start + index + 1];
        } else {
            index = index - frontSize;
            return back[backMid + index + 1];
        }
    }
}