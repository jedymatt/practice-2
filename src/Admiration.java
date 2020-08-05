
import java.util.Scanner;

public class Admiration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        int[][] members = new int[test][];
        for (int i = 0; i < test; i++) {
            int length = scanner.nextInt();
            members[i] = new int[length];
        }

        for (int i = 0; i < test; i++) {
            for (int j = 0; j < members[i].length; j++) {
                members[i][j] = j + 1;
            }
        }
        int[] memberOddAdmirers = new int[test];
        for (int i = 0; i < test; i++) {
            for (int j = 0; j < members[i].length; j++) {
                if (numberOfAdmirers(members[i], j) % 2 == 1) {
                    memberOddAdmirers[i]++;
                }
            }
        }

        for (int i = 0; i < test; i++) {
            System.out.println(memberOddAdmirers[i]);
        }

    }

    public static int numberOfAdmirers(int[] arr, int index) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[index] != arr[i] && arr[index] % arr[i] == 0) {
                count++;
            }
        }
        return count;
    }

}
