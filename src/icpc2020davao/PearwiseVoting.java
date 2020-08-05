package icpc2020davao;

import java.util.Arrays;
import java.util.Scanner;

public class PearwiseVoting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int candidate = scanner.nextInt();
        int ballot = scanner.nextInt();

        int[] votes = new int[ballot];
        char[][] positions = new char[ballot][candidate];
        for (int i = 0; i < ballot; i++) {
            votes[i] = scanner.nextInt();
            positions[i] = scanner.next().toCharArray();
        }
        char[] candidates = positions[0];
        Arrays.sort(candidates);

        for (int i = 0; i < candidate; i++) {
            System.out.print(candidates[i] + ": ");
            if (canWin(votes, positions, candidates[i])) {
                System.out.println("can win");
            } else {
                System.out.println("can't win");
            }
        }

    }

    private static boolean canWin(int[] votes, char[][] positions, char candidate) {
        char[] candidates = positions[0];
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == candidate) {
                continue;
            }
            char winner = winner(votes, positions, candidate, candidates[i]);
            if (candidate == winner) {
                return true;
            }
        }
        return false;
    }

    private static char winner(int[] votes, char[][] positions, char candidate, char compared) {
        int valueCandidate = 0;
        int valueCompared = 0;

        for (int i = 0; i < votes.length; i++) {
            int positionCandidate = -1;
            int positionCompared = -1;
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j] == candidate) {
                    positionCandidate = j;
                }
                if (positions[i][j] == compared) {
                    positionCompared = j;
                }
            }

            if (positionCandidate != -1 && positionCompared != -1) {
                if (positionCandidate < positionCompared) {
                    valueCandidate = valueCandidate + votes[i];
                } else {
                    valueCompared = valueCompared + votes[i];
                }
            }
        }

        return valueCandidate > valueCompared ? candidate : compared;
    }
}
