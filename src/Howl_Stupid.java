import java.util.Scanner;
public class Howl_Stupid {
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        System.out.print("AWH");
        for(int i = 0; i < A.length()-3; i++){
            System.out.print("0");
        }
    }
}
