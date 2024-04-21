package DPOP;
import java.util.Scanner;
public class Fallen_Chimney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Lowest_mBp = 0;
        for (int i = 0; i < N; i++) {
            int mBp = sc.nextInt();
            String not_fallen = sc.next();
            if(not_fallen.equals("nej") && mBp > Lowest_mBp){

                Lowest_mBp = mBp;
            }
        }
        System.out.println(Lowest_mBp);
    }
}
