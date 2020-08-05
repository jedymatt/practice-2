package checked;


import java.util.ArrayList;
import java.util.Scanner;

public class WordFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        for (int i = 0; i < getStringList(words).size(); i++) {
            System.out.print(getStringList(words).get(i));
            if (i < getStringList(words).size() -1) {
                System.out.print(" ");
            }
        }
        
    }
    
    private static int countTo(String[] words, String str) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(str)) {
                count++;
            }
        }
        return count;
    }
    
    private static ArrayList <String> getStringList(String[] words) {
        ArrayList <String> list = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (!list.contains(words[i])) {
                list.add(words[i]);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (countTo(words,list.get(i)) > countTo(words,list.get(j))) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
