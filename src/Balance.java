import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Balance {
    public static void main(String[] args){
        int para = 0;
        int brackets = 0;
        Boolean balance = true;
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] splitinput = input.split(",");
        List<String> input_list = new LinkedList<String>(Arrays.asList(splitinput));

        for(int i = 0; i < input_list.size(); i++){

            if(input_list.get(i).equals("(")){
                para++;
                try {
                    if(input_list.get(i+1).equals("]")) {
                        balance = false;
                    }
                }catch(IndexOutOfBoundsException e){}

            } else if (input_list.get(i).equals("[")) {
                brackets++;
                try {
                    if(input_list.get(i+1).equals(")")){
                        balance = false;
                    }
                }catch(IndexOutOfBoundsException e){}

            } else if (input_list.get(i).equals(")")) {
                if(para == 0){
                    balance = false;
                }
                if(para > 0) {
                    para--;
                }

            } else if (input_list.get(i).equals("]")) {
                if(brackets == 0){
                    balance = false;
                }
                if(brackets > 0) {
                    brackets--;
                }
            }
        }
        if(balance && para == 0 && brackets == 0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
