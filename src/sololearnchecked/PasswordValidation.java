package sololearnchecked;

import java.util.*;
public class PasswordValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.next();
        
        if (isValid(input)) {
            System.out.println("Strong");
        } else {
            System.out.println("Weak");
        }
    }
    
    private static boolean hasNumbers(String str) {
        int count = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 48; j <= 57; j++) {
                if (arr[i] == j) {
                    count++;
                    break;
                }
            }
        }
        return count >= 2;
    }
    
    private static boolean hasSpecialChar(String str){
        int count = 0;
        char[] arr = str.toCharArray();
        char[] spChar = {'!','@','#','$','%','&','*'};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < spChar.length; j++) {
                if (arr[i] == spChar[j]) {
                    count++;
                    break;
                }
            }
        }
        return count >= 2;
    }
    
    private static boolean hasMinimumLength(String str) {
        return str.length() >= 7;
    }
    
    private static boolean isValid(String str) {
        return hasNumbers(str) && hasSpecialChar(str) && hasMinimumLength(str);
    }
}
