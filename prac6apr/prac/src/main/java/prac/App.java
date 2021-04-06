package prac;

import java.util.HashMap;
import java.util.Scanner;

public final class App {
    public static void main(String[] args) {
        // var students = new HashMap<Integer, String>();
        // students.put(21001, "Vasyl");
        // students.put(21002, "Maria");
        // students.put(21003, "Mykola");

        // for (var s : students.entrySet()) {
        //     System.out.println(s.getKey() + " " + s.getValue());
        // }

        // System.out.print("input key to search: ");

        // var scanner = new Scanner(System.in);
        
        // var key  = scanner.nextInt();
        // var stud = students.get(key);
        // if (stud != null) {
        //     System.out.println(stud);
        // } else {
        //     System.out.println("no student with this key exists");
        // }

        var students = new HashMap<Student, Float>();

        var s1 = new Student("Vasyl", "K", 1);
        var s2 = new Student("Maria", "M", 1);
        var s3 = new Student("Maria", "N", 1);
        var s4 = new Student("Maria", "K", 1);
        var s5 = new Student("Maria", "K", 1);

        students.put(s1, (float) 60.0);
        students.put(s2, (float) 80.0);
        students.put(s3, (float) 90.0);
        students.put(s4, (float) 100.0);
        students.put(s5, (float) 70.0);

        for (var s : students.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
