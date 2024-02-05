import java.util.Scanner;
public class nsum {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int b = 0;
        for(int i = 0; i < N; i++){
            int a = s.nextInt();
            b = b + a;
        }
        System.out.println(b);
    }
}
