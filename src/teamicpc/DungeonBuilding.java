
import java.util.*;

public class DungeonBuilding {

    private static String[][] addToDiag(String[][] diag, String r, int a, int b) {
        String temp[][] = diag;
        temp[a][b] = ".";
        return temp;
    }

    private static String[][] fill(String[][] diag) {
        String temp[][] = diag;

        for (int x = 0; x < temp.length; x++) {
            for (int y = 0; y < temp.length; y++) {
                temp[x][y] = "#";
            }
        }

        return temp;
    }

    private static String[][] connect(String[][] diag) {
        String temp[][] = diag;

        for (int x = 1; x < temp.length; x += 3) {
            for (int y = 1; y < temp.length; y += 3) {
                if (".".equals(temp[x][y])) {
                    if (y + 3 < temp.length) {
                        if (".".equals(temp[x][y + 3])) {
                            temp[x][y + 1] = ".";
                            temp[x][y + 2] = ".";
                        }
                    }
                }
            }
        }

        for (int a = 1; a < temp.length; a += 3) {
            for (int b = 1; b < temp.length; b += 3) {
                if (".".equals(temp[b][a])) {
                    if (b + 3 < temp.length) {
                        if (".".equals(temp[b + 3][a])) {
                            temp[b + 1][a] = ".";
                            temp[b + 2][a] = ".";
                        }
                    }
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[][] = new int[n][n];
        String diag[][] = new String[n * 3][n * 3];
        diag = fill(diag);
//        String r0[][] = {{"#","#","#"}, {"#",".","#"}, {"#","#","#"}};
//        String r1[][] = {{"#","#","#"}, {"#","#","#"}, {"#","#","#"}};

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                arr[x][y] = in.nextInt();
            }
        }

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                if (arr[x][y] == 0) {
                    diag = addToDiag(diag, ".", 1 + (x * 3), 1 + (y * 3));
                }
            }
        }

        diag = connect(diag);

        for (int x = 0; x < diag.length; x++) {
            for (int y = 0; y < diag.length; y++) {
                System.out.print(diag[x][y]);
            }
            System.out.println();
        }
    }
}
