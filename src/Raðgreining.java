import java.util.Scanner;

public class Raðgreining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // length of sequence
        int m = sc.nextInt(); // Amount of parsed words
        char[] sequence = new char[n];
        boolean villa = false;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                if(sequence[(a-1)+j] != '\0' && sequence[(a-1)+j] != s.charAt(j)){ villa = true; break; }
                sequence[(a - 1) + j] = s.charAt(j);
            }

        }
        for (int j = 0; j < n; j++) {
            if (sequence[j] == '\0') {
                sequence[j] = '?';
            }
        }
        if(villa){
            System.out.println("Villa");
        }else {
            System.out.println(new String(sequence));
            // output one line the length of n
        }
    }
}
