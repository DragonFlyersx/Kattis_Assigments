import java.util.Scanner;
public class howl {

    public static void main(String[] args){
        boolean Asat = true;
        Scanner s = new Scanner(System.in);
        String N = s.next();
        int k = N.length()+1;
        String[] newAr = new String[k];
        newAr[0] =  "A";
        for(int i = 0; i < k-1; i++){
            if(i == k-3){
                newAr[i+1] =  "H";
            }else if(i >= k-2) {
                newAr[i+1] =  "O";
            }else if(Asat){
                newAr[i+1] =  "W";
                Asat = false;

            } else if (!Asat) {
                newAr[i+1] =  "A";
                Asat = true;
            }
        }
        for(String x : newAr){
            System.out.print(x);
        }
    }
}


