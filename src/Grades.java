import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Grades {
    public static void main(String [] args) throws FileNotFoundException{
        File file = new File("Data/GradeAsignment/2.in");
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
                .comparingDouble((Students student) -> student.grade)
                        .reversed()
                .thenComparing(Students -> Students.name));
        //prints students
        for(Students t : AllStudents){
            System.out.println(t.name);
        }
    }
}
 class Students {
     String name;
     double grade;
     double value;

     public Students(String name, String grade) {
         this.name = name;
         switch (grade.replaceAll("[+-]","")) {
             case "A":
                 value = 350;
                 break;
             case "B":
                 value = 300;
                 break;
             case "C":
                 value = 250;
                 break;
             case "D":
                 value = 200;
                 break;
             case "E":
                 value = 150;
                 break;
             case "FX":
                 value = 100;
                 break;
             case "F":
                 value = 50;
                 break;
         }
         if (grade.contains("+") || grade.contains("-")) {
             //lav en modifier for længden af minus og plus så den trækker 1.1111 væk eller tilføjer
             if (grade.contains("-")) {
                 double amount_minus = grade.length() - (grade.replaceAll("-", "").length());
                 value = value - (amount_minus/100.0);
             } else if (grade.contains("+")) {
                 double amount_plus = grade.length() - (grade.replaceAll("[+]", "").length());
                 value = value + (amount_plus/100.0);
             }
         }
         this.grade = value;
    }
}