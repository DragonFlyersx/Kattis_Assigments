import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Homemade_QF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components
    private int accescount;


    public Homemade_QF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;

    }


    public int count() {
        return count;
    }

    public int getAccescount(){return accescount;}


    public int find(int p) {
        validate(p);
        accescount++;
        return id[p];
    }


    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }


    @Deprecated
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }


    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   // needed for correctness
        int qID = id[q];   // to reduce the number of array accesses
        accescount = accescount + 2;
        // p and q are already in the same component
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++){
            accescount  = accescount + 10;
            if (id[i] == pID){ id[i] = qID;
                accescount++;}
        }

        count--;
    }


    public static void main(String[] args) {
        int n = StdIn.readInt();
        Homemade_QF uf = new Homemade_QF(n);

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q))
            uf.union(p, q);
            StdOut.println(p + " " + q);

        StdOut.println(uf.count() + " components");
        System.out.println(uf.getAccescount());
    }

}
