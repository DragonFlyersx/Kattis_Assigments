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
                .comparing((Students student) -> student.grade)
                .thenComparing(Students -> Students.name));

        //prints students
        for(Students t : AllStudents){
            System.out.println(t.name);
        }

    }
}
 class Students{
    String name;
    String grade;
    public Students(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
}