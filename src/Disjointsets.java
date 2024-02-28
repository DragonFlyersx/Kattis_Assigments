import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;
public class Disjointsets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int p;
        int q;
        UF uf = new UF(N);
        int lines = s.nextInt();
        for (int i = 0; i < lines; i++) {
            int M = s.nextInt();
            switch (M) {
                case (0):
                    p = s.nextInt();
                    q = s.nextInt();
                    if (uf.connected(p, q)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case (1):
                    p = s.nextInt();
                    q = s.nextInt();
                    uf.union(p, q);
                    break;
                case (2):
                    p = s.nextInt();
                    q = s.nextInt();
                    uf.find(p); // find parent af int p men gør det til sin egen parent og sæt ind i union med q.
                    break;
            }
        }
    }
}


