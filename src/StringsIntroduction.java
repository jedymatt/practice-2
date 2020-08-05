


public class StringsIntroduction {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        System.out.println(lengthTo(a,b));
        if (!isLarger(a,b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        System.out.println(output(a,b));
    }
    
    public static int lengthTo(String a, String b) {
        return a.length() + b.length();
    }
    
    public static boolean isLarger(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        
        int length;
        if (charA.length < charB.length) {
            length = charA.length;
        } else {
            length = charB.length;
        }
        
        for (int i = 0; i < length; i++) {
            if (charA[i] < charB[i]) {
                return true;
            } else if(charA[i] > charB[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static String output(String a, String b) {
        a  = a.replaceFirst(a.substring(0, 1), a.substring(0, 1).toUpperCase());
        b  = b.replaceFirst(b.substring(0, 1), b.substring(0, 1).toUpperCase());
        return a.concat(" ").concat(b);
    }
}
