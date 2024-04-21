package DPOP;

import java.util.Scanner;
public class Set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Set = sc.nextLine();
        String[] points = Set.split("-");
        int a = Integer.parseInt(points[0]);
        int b = Integer.parseInt(points[1]);

      if((a == 30 && b != 30) || (a == 21 && b <= a - 2) || (a >= 22 && b == a - 2)){ // handles win condition
      System.out.println("A");
      }else if((a != 30 && b == 30) || (b == 21 && a <= b - 2) || (b >= 22 && a == b - 2)){ // handles win condition
          System.out.println("B");
      }else if ((a < 21 && b < 21) || (a >= 21 && a == b + 1) || (b >= 21 && b == a + 1)){ // handles game in progress
          System.out.println("?");
      } else {
          System.out.println("!");
      }
    }
}