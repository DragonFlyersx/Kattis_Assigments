import java.util.Scanner;
public class coffeecupcombo {
    public static void main(String[] args){
        int coffesatisfaction = 0;
        int hours = 0;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String x = s.nextLine();
        String[] str = x.split("");
        int[] arr = new int[n];
        for(int i = 0; i < x.length(); i++){
            arr[i] = Integer.parseInt(str[i]);
        }
       for(int c : arr){
            if(c == 1){
                coffesatisfaction = 2;
                hours++;
            } else if (c == 0 && coffesatisfaction > 0) {
                hours++;
                coffesatisfaction--;
            }

        }
        System.out.println(hours);
    }
}
