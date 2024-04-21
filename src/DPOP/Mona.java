package DPOP;
import java.util.Scanner;
public class Mona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Sc = sc.nextLine();
        String[] words = Sc.split(" ");
        String name = words[0];
        System.out.println(name + " " + name + " " + name);
    }
}
