package teamicpc;

import java.util.*;

public class RegionalTeamNames {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = "";
        String out = "NO";
        while (str.length() < 1 || str.length() > 80) {
            str = in.nextLine();
        }

        if (str.contains("-")) {
            if (!str.contains(" ")) {
                String words[] = str.split("-");

                if (words[0].length() > 1 && words[0].length() <= 8) {
                    if (words[1].length() >= 1 && words[1].length() <= 24) {
                        out = "YES";
                    }
                }
            }
        }

        System.out.println(out);
    }
}
