package array;

public class StringSortAlphabetical {

    public static void main(String[] args) {
        String[] words = {"Hello", "World", "Java", "I", "Am", "Zed"};
        sortAscend(words);
        for (String i : words) {
            System.out.println(i);
        }
        

    }

    private static void sortAscend(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (isFirstChar(arr[i], arr[j])) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void sortDescend(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!isFirstChar(arr[i], arr[j])) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static boolean isFirstChar(String a, String b) {
        char[] charA = a.toLowerCase().toCharArray();
        char[] charB = b.toLowerCase().toCharArray();

        int length;
        if (charA.length < charB.length) {
            length = charA.length;
        } else {
            length = charB.length;
        }

        for (int i = 0; i < length; i++) {
            if (charA[i] < charB[i]) {
                return true;
            } else if (charA[i] > charB[i]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(String[] dst, int indexOne, int indexTwo) {
        String temp = null;
        temp = dst[indexOne];
        dst[indexOne] = dst[indexTwo];
        dst[indexTwo] = temp;
    }

    private static int shortLength(String a, String b) {
        if (a.length() < b.length()) {
            return a.length();
        } else {
            return b.length();
        }
    }
}
