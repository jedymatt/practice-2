package icpc2020davao;

import java.util.Scanner;

public class RegionalTeamNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ((institution(input).length() > 1 && institution(input).length() <= 8)
                && (teamName(input).length() > 0 && teamName(input).length() <= 24)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static String institution(String str) {
        return str.contains("-") ? str.substring(0, str.indexOf('-')) : str;
    }

    private static String teamName(String str) {
        return str.contains("-") ? str.substring(str.indexOf('-') + 1, str.length()) : "";
    }

}
