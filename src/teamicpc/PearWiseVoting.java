package teamicpc;

import java.util.*;

public class PearWiseVoting {

    static int pair1 = 0;
    static int pair2 = 1;
    static int p[];
    static char nP[][];
    static char chars[];
    static String votes[];

    private static String[] getVotes(int p[], char chars[], char nP[][], String votes[], int m, int n) {
        int count1 = 0;
        int count2 = 0;

        for (int a = 0; a < m; a++) {
            votes[a] = "can't win";
            for (int b = 0; b < m; b++) {
                if (a == b) {
                    continue;
                }

                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        if (nP[x][y] == chars[a]) {
                            count1 += p[x];
                            break;
                        } else if (nP[x][y] == chars[b]) {
                            count2 += p[x];
                            break;
                        }
                    }
                }

                if (count1 > count2) {
                    votes[a] = "can win";
                    break;
                }
            }
        }

        return votes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        p = new int[m];
        nP = new char[m][n];
        chars = new char[n];
        votes = new String[n];

        for (int x = 0; x < m; x++) {
            p[x] = in.nextInt();
            String str = in.next().toUpperCase();
            nP[x] = str.toCharArray();
            chars = str.toCharArray();
        }

        Arrays.sort(chars);

        votes = getVotes(p, chars, nP, votes, m, n);

        for (int x = 0; x < m; x++) {
            System.out.println(chars[x] + ": " + votes[x]);
        }

    }
}
