import java.util.Scanner;
import edu.princeton.cs.algs4.MaxPQ;

public class Seat_allocation_test_OBject {
    public static void main(String[] args) {
        // Læs input
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        // Liste af partier
        Parti[] Partier = new Parti[n];
        // Max oriented priority que/ heap
        MaxPQ<Parti> PQ = new MaxPQ<>();
        // Indsæt partier i PQ
        for(int i = 0; i < n; i++){
            int votes = s.nextInt();
            Parti part = new Parti(i + 1, votes);
            PQ.insert(part);
            Partier[i] = part;
        }
        // tag højeste parti i PQ beregn ny værdi nu hvor der et sæde mere og tilføj igen til PQ
        for(int j = 0; j < m; j++){
            Parti part = PQ.delMax();
            part.addSeat();
            part.Calculatequote();
            PQ.insert(part);
        }

        // Printer seats ud
        for (Parti P : Partier) {
            System.out.println(P.getseats());
        }
    }


}
class Parti implements Comparable<Parti> {
    int id;
    int votes;
    int seats;
    double quote;
    public Parti(int id, int votes)  {
        this.id = id;
        this.votes = votes;
        this.seats = 0;
        this.quote = votes;
    }
    int getvotes() {
        return votes;
    }
    int getseats() {
        return seats;
    }
    void addSeat(){
        seats++;
    }
    // beregner Værdien ved brug af Dhonds metode
    public void Calculatequote(){
        this.quote = votes / (seats + 1.0);
    }
    // Dette er det som PQ bruger til at compare med. I andre ord det nummer den sammenligner efter hvad som er størts
    @Override
    public int compareTo(Parti second){
        return Double.compare(this.quote, second.quote);
    }
}


