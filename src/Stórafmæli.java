import java.util.Scanner;

public class Stórafmæli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int years = sc.nextInt();
        if ((years)%10 == 0) {
            System.out.println("Jebb");
        }else{
            System.out.println("Neibb");
        }
    }
}
