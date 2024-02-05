import java.util.Scanner;
public class Bannorð {
    public static void main(String [] args){
        Scanner  s =  new Scanner(System.in);
        String bad = s.nextLine();
        boolean badcounter;
        String [] badchars = bad.split("",bad.length());
        while(s.hasNext()) {
            badcounter = false;
            String word = s.next();
            for (String a : badchars) {
                if (word.contains(a)) {
                    badcounter = true;
                    }
                }
            if(badcounter){
            for (int i = 0; i < word.length(); i++) {
                System.out.print("*");}}
            else {
                System.out.print(word);
            }
                System.out.print(" ");
            }
        }
    }

