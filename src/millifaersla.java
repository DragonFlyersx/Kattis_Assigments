import java.util.Scanner;
public class millifaersla {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int Monnei = S.nextInt();
        int Fjee = S.nextInt();
        int Dolladollabilljoll = S.nextInt();

        if(Monnei < Fjee && Monnei < Dolladollabilljoll){
            System.out.println("Monnei");
        } else if (Fjee < Monnei && Fjee < Dolladollabilljoll) {
            System.out.println("Fjee");
        }else if (Dolladollabilljoll < Monnei && Dolladollabilljoll < Fjee) {
            System.out.println("Dolladollabilljoll");
        }
    }


}
