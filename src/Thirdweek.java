import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Thirdweek {

    public static void main(String[] args) {
        boolean match = false;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        List<String> list_S = new LinkedList<String>();
        String[] Ssplit = s.split("");
        list_S = Arrays.asList(Ssplit);
        String[] tsplit = t.split("");
        List<String> list_t = new LinkedList<String>(Arrays.asList(tsplit));
        int count = 0;
        int NotCirular = 0;
        int j = list_S.size();;

        while (!match) {

            for (int i = 0; i < j; i++) {

                if (list_S.get(i).equals(list_t.get(i))) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count == j) {
                System.out.println("The strings are circular shifts of each other");
                match = true;
            } else {
                String x = list_t.get(j - 1);
                list_t.remove(j - 1);
                list_t.add(0, x);
                if(NotCirular > j){
                    System.out.println("Not circular");
                    break;
                }
                NotCirular++;

            }
        }
    }
}

