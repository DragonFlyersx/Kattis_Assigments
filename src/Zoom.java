import java.util.Scanner;
public class Zoom {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        int zoom_amount = s.nextInt();

        for(int i = 0; i < n;i++){
            arr[i] = s.nextInt();
            }

        for(int j = 0; j < n; j++){
            if((j+1)%zoom_amount == 0){
                System.out.println(arr[j]);
            }
        }
    }
}

