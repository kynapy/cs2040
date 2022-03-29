// Kattis ID: nicknames
// Time taken: 0.54s, Fastest time: 0.43s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Nicknames {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        int numNames = Integer.parseInt(br.readLine());
        AVLTree avltree = new AVLTree();
        HashMap<String, Integer> record = new HashMap<String, Integer>();
        for (int i = 0; i < numNames; i++) {
            String name = br.readLine();
            avltree.insert(name);
        }
        int numNicknames = Integer.parseInt(br.readLine());
        for (int i = 0; i < numNicknames; i++) {
            String nickname = br.readLine();
            if (record.get(nickname) != null) {
                pw.println(record.get(nickname));
            } else {
                int matches = avltree.search(nickname);
                record.put(nickname, matches);
                pw.println(matches);
            }
        }
        pw.close();
    }
}

class AVLVertex { // Done, no need size
    public AVLVertex parent, left, right;
    public String key;
    public int height;

    AVLVertex(String name) {
        key = name;
        parent = left = right = null;
        height = 0;
    }
}

class AVLTree {
    public AVLVertex root;

    AVLTree() { 
        root = null;
    }

    // Tree Balancing Functions
    public AVLVertex rotateLeft(AVLVertex vertex) {
        AVLVertex r = vertex.right;
        r.parent = vertex.parent;
        vertex.parent = r;
        vertex.right = r.left;
        if (r.left != null) {
            r.left.parent = vertex;
        }
        r.left = vertex;
        updateHeight(vertex);
        updateHeight(r);
        return r;
    }

    public AVLVertex rotateRight(AVLVertex vertex) {
        AVLVertex l = vertex.left;
        l.parent = vertex.parent;
        vertex.parent = l;
        vertex.left = l.right;
        if (l.right != null) {
            l.right.parent = vertex;
        }
        l.right = vertex;
        updateHeight(vertex);
        updateHeight(l);
        return l;
    }

    // BST Functions required: Searching, insertion
    public void insert(String name) { // Done
        root = insert(root, name);
    } 

    public AVLVertex insert(AVLVertex vertex, String name) { // Done
        if (vertex == null) {
            return new AVLVertex(name);
        }
        else if (vertex.key.compareTo(name) < 0) {
            vertex.right = insert(vertex.right, name);
            vertex.right.parent = vertex;
        } else {
            vertex.left = insert(vertex.left, name);
            vertex.left.parent = vertex;
        }
        updateHeight(vertex);
        if (balanceFactor(vertex) == 2) {
            if (balanceFactor(vertex.left) == -1) {
                vertex.left = rotateLeft(vertex.left);
            }
            return rotateRight(vertex);
        }
        else if (balanceFactor(vertex) == -2) {
            if (balanceFactor(vertex.right) == 1) {
                vertex.right = rotateRight(vertex.right);
            }
            return rotateLeft(vertex); 
        } else {
            return vertex;
        }
    }

    public int balanceFactor(AVLVertex vertex) { // Done
        if (vertex.right == null & vertex.left == null) {
            return 0;
        }
        else if (vertex.right == null) {
            return vertex.left.height + 1;
        }
        else if (vertex.left == null) {
            return -1 - vertex.right.height;
        } else {
            return vertex.left.height - vertex.right.height;
        }
    }

    public void updateHeight(AVLVertex vertex) { // Done
        if (vertex.right == null && vertex.left == null) {
            vertex.height = 0;
        }
        else if (vertex.right == null) {
            vertex.height = vertex.left.height + 1;
        } 
        else if (vertex.left == null) {
            vertex.height = vertex.right.height + 1;
        } else {
            vertex.height = Math.max(vertex.left.height, vertex.right.height) + 1;
        }
    }
    
    public int search(String s) { // Done
        return search(root, s);
    }

    public int search(AVLVertex vertex, String s) {
        if (vertex == null) {
            return 0;
        }
        if (vertex.key.indexOf(s) == 0) {
            return 1 + search(vertex.left, s) + search(vertex.right, s);
        } 
        else {
            if (vertex.key.compareTo(s) > 0) {
                return search(vertex.left, s) + 0;
            } else {
                return search(vertex.right, s) + 0;
            }
        }
    }
}