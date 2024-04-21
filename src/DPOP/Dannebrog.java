package DPOP;
import java.util.Scanner;
public class Dannebrog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height_Of_flag_with_cross = sc.nextInt();
        int height_Of_flag = height_Of_flag_with_cross - (height_Of_flag_with_cross / 7);
        int Perfect_square = height_Of_flag * height_Of_flag;
        System.out.println(Perfect_square + (Perfect_square / 4));


    }
}
