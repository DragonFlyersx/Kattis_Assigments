import java.util.Scanner;
import java.util.Stack;
public class Balance2 {
    public static void main(String[] args){
        boolean Balance = true;
        Scanner s = new Scanner(System.in);
        char[] input = s.nextLine().toCharArray();
        Stack<Character> Stck = new Stack<>();
        for(int i = 0; i < input.length; i++){

            if(input[i] == '('){
                Stck.push(input[i]);
            }

            if(input[i] == '['){
                Stck.push(input[i]);
            }

            if(input[i] == ')'){
                if(Stck.empty() || !(Stck.pop() == '(')){ // Dette virker bedre end at peek char og så poppe i kattis
                    Balance = false;
                }
            }
            if(input[i] == ']'){
                if(Stck.empty() || !(Stck.pop() == '[')){
                    Balance = false;
                }
            }
        }
        if(!Stck.empty()){
            Balance = false;
        }
        if(Balance){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}