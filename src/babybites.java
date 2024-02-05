import java.util.Scanner;
public class babybites {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean makesence = true;
        for(int i = 0; i < N; i++){
            if(s.hasNextInt()){
                int a = s.nextInt();
                if(a != i +1){
                    makesence = false;
                }
            }else{
               String b = s.next();
            }
        }
        if(makesence){
            System.out.println("makes sense");
        }else{
            System.out.println("something is fishy");
        }
    }
}
