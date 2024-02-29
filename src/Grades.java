import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import edu.princeton.cs.algs4.Insertion;

public class Grades {
    public static void main(String [] args) throws FileNotFoundException{
        File file = new File("Data/GradeAsignment/1.in");

        Scanner scanner = new Scanner(file); // use File for file
        int s = scanner.nextInt();

        // Creates the array of Students
        Students[] AllStudents = new Students[s];


        // adding the students to the Array
        for(int i = 0; i < s; i++){
            AllStudents[i] = new Students(scanner.next(), scanner.next());
        }

        // Array sort with custom Comparing settings.

        Arrays.sort(AllStudents, Comparator
                .comparingInt((Students student) -> student.grade)
                        .reversed()
                .thenComparing(Students -> Students.name));

        //prints students
        for(Students t : AllStudents){
            System.out.println(t.name);
        }

    }
}
 class Students{
    String name;
    int grade;
    public Students(String name, String grade) {
        this.name = name;



        switch (grade){
            case "A":
                this.grade = 350;
                break;
            case "B":
                this.grade = 300;
                break;
            case "C":
                this.grade = 250;
                break;
            case "D":
                this.grade = 200;
                break;
            case "E":
                this.grade = 150;
                break;
            case "FX":
                this.grade = 100;
                break;
            case "F":
                this.grade = 50;
                break;



        }
    }
}