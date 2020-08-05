package checked;


import java.util.Scanner;

public class SymmetricSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < toSwap(a).length; i++) {
            System.out.print(toSwap(a)[i]);
            if (i < toSwap(a).length - 1) {
                System.out.print(" ");
            }
        }
    }
    
    
    private static int[] toSwap(int[] a){
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[(a.length-1) - i] = a[i];
        }
        return arr;
    }
    
}
