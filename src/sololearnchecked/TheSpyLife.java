package sololearnchecked;


import java.util.*;

public class TheSpyLife {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        System.out.println(decode(input));
    }

    private static String flipTo(String str) {
        
        char[] arr = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt((str.length() - 1) - i);
        }

        return new String(arr);
    }

    private static String removeNonLetter(String str) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String letters = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    letters = letters + alphabet.charAt(j);
                    break;
                }
            }
        }
        return letters;
    }
    
    private static String decode(String str) {
        return removeNonLetter(flipTo(str));
    }
}
