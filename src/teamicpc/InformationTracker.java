import java.util.*;

public class InformationTracker {
    private static ArrayList <Integer> compare(ArrayList <Integer> list, int a, int b){
        boolean chk = false;
        int temp = 0;
        
        for(int x = 0; x < list.size(); x++) {
            if(list.get(x) == a) {
                chk = true;
                temp = b;
                break;
            }
            else if(list.get(x) == b) {
                chk = true;
                temp = a;
                break;
            }
        }
        
        if(chk)
            if (chkDistinct(list, temp))
                list.add(temp);
        
        return list;
    }
    
    private static boolean chkDistinct(ArrayList <Integer> list, int a) {
        for(int x = 0; x < list.size(); x++) {
            if (list.get(x) == a)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        
        for (int x = 0; x < m; x++) {
            list = compare(list, arr[x][0], arr[x][1]);
        }
        
        System.out.println(list.size());
    }
}