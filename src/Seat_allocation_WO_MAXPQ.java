import java.util.Scanner;

public class Seat_allocation_WO_MAXPQ {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] votes = new int[n];

        for(int i = 0; i < n; i++) {
            votes[i] = s.nextInt();
        }
        // resutalt af d hands method
        int[] seats = dhondtmethod(n,m, votes);

        // Printer seats ud
        for(int i : seats){
            System.out.println(i);
        }
    }
    //d hond's metode
    public static int[] dhondtmethod(int n, int m, int[] votes){
        // først lav tomme integers arrays med størrelsen af parties
        int[] parties = new int[n];
        int[] already_seats = new int[n];

        //Runde tæller
        for(int runde = 0; runde < m; runde++ ){
            // Partier
           for(int i = 0; i < n;i++){
               //dhondmethod calculation
               parties[i] = votes[i] / (1 + already_seats[i]);
           }
           // Her stiger vi allerede lokeret seat med en da det er vinderen
           already_seats[findmax(parties)]++;

        }
        // retur arrayet med seats
        return already_seats;
    }


    //funktion for at returnere índexet på det største element i et array
    public static int findmax(int [] ar) {
        int max = 0;
        for (int i = 1; i < ar.length; i++) {
        if(ar[i] > ar[max]){
            max = i;
            }
        }
        return max;
    }

}
