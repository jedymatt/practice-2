package checked;

import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int[] year = new int[t];
        for (int i = 0; i < t; i++) {
            year[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            if (isLeapYear(year[i])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    
    private static boolean isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }
}
