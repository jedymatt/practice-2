
import java.util.Scanner;

public class PigLatin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String english = sc.nextLine();
        String[] words = english.split(" ");
        System.out.println(pigLatinString(words));
    }

    private static String pigLatinString(String[] str_arr) {
        String value = "";
        for (int i = 0; i < str_arr.length; i++) {
            value += pigLatinWord(str_arr[i], 0, "ay");
            if (i < str_arr.length - 1) {
                value += " ";
            }
        }
        return value;
    }

    private static String pigLatinWord(String str, int source, String postfix) {
        return str.substring(source + 1, str.length()) + str.charAt(source) + postfix;
    }
}
