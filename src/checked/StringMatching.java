package checked;

import java.util.Scanner;
public class StringMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] n = new String[t], f = new String[t];
        for (int i = 0; i < t; i++) {
            n[i] = sc.next();
            f[i] = sc.next();
        }
        for (int i = 0; i < t; i++) {
            if (containsSequence(n[i],f[i])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
    }
    
    private static boolean containsSequence(String n, String f) {
        return n.contains(f);
    }
}
