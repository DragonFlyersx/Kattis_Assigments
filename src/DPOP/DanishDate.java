package DPOP;
import java.util.Scanner;
public class DanishDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] date = sc.nextLine().split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        String monthName = "error";
        switch (month) {
            case 1:
                monthName = "januar";
                break;
            case 2:
                monthName = "februar";
                break;
            case 3:
                monthName = "marts";
                break;
            case 4:
                monthName = "april";
                break;
            case 5:
                monthName = "maj";
                break;
            case 6:
                monthName = "juni";
                break;
            case 7:
                monthName = "juli";
                break;
            case 8:
                monthName = "august";
                break;
            case 9:
                monthName = "september";
                break;
            case 10:
                monthName = "oktober";
                break;
            case 11:
                monthName = "november";
                break;
            case 12:
                monthName = "december";
                break;
        }

        System.out.println(day+"."+" "+ monthName + " " + year);


    }
}
