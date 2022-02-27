// Time Taken: 0.25s, Kattis Best: 0.17s

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class SortOfSorting {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numOfStudents = Integer.parseInt(br.readLine());
        
        // Loops until 0 is inputted
        while (numOfStudents != 0) {
            // Used to store all the students
            ArrayList<Student> students = new ArrayList<Student>(numOfStudents);

            // Adding students into ArrayList
            for (int i = 0; i < numOfStudents; i++) {
                Student s = new Student(br.readLine());
                students.add(s);
            }

            // Sorting the students based on first two letters
            Collections.sort(students);
            
            // Printing out each student for that round
            for (int i = 0; i < numOfStudents; i++) {
                pw.println(students.get(i).name);
            }

            // Start next round of students
            pw.println("");
            numOfStudents = Integer.parseInt(br.readLine());
        }

        // Output everything at the end
        pw.close();
    }
}

class Student implements Comparable<Student> {
    public final String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.substring(0,2).compareTo(other.name.substring(0,2));
    }
}