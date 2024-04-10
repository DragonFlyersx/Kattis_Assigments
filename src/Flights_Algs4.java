import java.util.Scanner;
import edu.princeton.cs.algs4.RedBlackBST;
public class Flights_Algs4 {
    public static void main(String []args){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(); // Amount of planes coming in with a time stamp and destination seperated by a space
            int m = scanner.nextInt(); // Amount of commands coming in
            scanner.nextLine();
            //create Binary Search Tree
            RedBlackBST Search = new RedBlackBST();
            for(int i = 0; i < n; i++){
                // Take in flight split line create flight object use time as second bst
                String flight = scanner.nextLine();

                String[] parts = flight.split(" ");
                Search.put(timeasseconds(parts[0]),parts[1]);


            }
            for(int j = 0; j < m; j++){
                String command = scanner.nextLine();
                String[] command_parts = command.split(" ");

                switch (command_parts[0]){
                    case "destination":
                        destination(Search, timeasseconds(command_parts[1]));
                        break;
                    case "cancel":
                        cancel(Search,timeasseconds(command_parts[1]));
                        break;
                    case "delay":
                        delay(Search,timeasseconds(command_parts[1]),Integer.parseInt(command_parts[2]));
                        break;
                    case "reroute":
                        reroute(Search,timeasseconds(command_parts[1]),command_parts[2]);
                        break;
                    case "next":
                        next(Search, timeasseconds(command_parts[1]));
                        break;
                    case "count":
                        count(Search, timeasseconds(command_parts[1]), timeasseconds(command_parts[2]));
                        break;
                }
            }

        }

        private static int timeasseconds(String time){
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);

            return hours * 3600 + minutes * 60 + seconds;
        }

        private static String Second_to_Time(int Seconds){
            int hours = Seconds/ 3600;
            int remainingSeconds = Seconds % 3600;
            int minutes = remainingSeconds / 60;
            int second = remainingSeconds % 60;
            return String.format("%02d:%02d:%02d", hours,minutes,second);
        }

        private static void destination(RedBlackBST search, int s){
            if(search.get(s) != null) System.out.println(search.get(s));
            else System.out.println("-");
        }

        private static void reroute(RedBlackBST search, int s, String c){
            search.put(s,c);
        }

        private static void cancel(RedBlackBST search, int s){
            search.delete(s);
        }

        private static void delay(RedBlackBST search, int s, int d){
            int new_time = s+d;
            search.put(new_time,search.get(s));
            search.delete(s);


        }
        private static void next(RedBlackBST search, int s){
            int next_flight = (int) search.ceiling(s);
            System.out.println(Second_to_Time(next_flight) + " " + search.get(next_flight));
        }

        private static void count(RedBlackBST search, int t1, int t2){
        System.out.println(search.size(t1,t2));


    }
}

