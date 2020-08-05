package icpc2020davao;


import java.util.*;

public class InformationTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] friends = new int[m][2];
        for (int i = 0; i < m; i++) {
            friends[i][0] = sc.nextInt();
            friends[i][1] = sc.nextInt();
        }

        System.out.println(toMeet(friends));

    }

    private static int toMeet(int[][] friends) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {

            if (!list.isEmpty() && friends[i][0] == list.get(list.size() - 1)) {
                if (!list.contains(friends[i][0])) {
                    list.add(friends[i][0]);
                } else if (!list.contains(friends[i][1])) {
                    list.add(friends[i][1]);
                }
            } else if (!list.isEmpty() && friends[i][1] == list.get(list.size() - 1)) {
                if (!list.contains(friends[i][1])) {
                    list.add(friends[i][1]);
                } else if (!list.contains(friends[i][0])) {
                    list.add(friends[i][0]);
                }
            }
            if (friends[i][0] == 1) {
                list.add(friends[i][0]);
                list.add(friends[i][1]);

            } else if (friends[i][1] == 1) {
                list.add(friends[i][0]);
            }
        }

        return list.size();
    }
}
