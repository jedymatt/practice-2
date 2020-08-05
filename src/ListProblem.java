import java.util.*;
import javax.swing.Action;
public class ListProblem {

    public static void main(String[] args) {
        
        List<String> listOne = new ArrayList<>();
        
        List<String> listTwo = listOne;
        
        String hello = "Hello", world = "World";

        listTwo.add(world);
        listOne.add(hello);
        
        for (String i : listOne) {
            System.out.println(i);
        }
    }
}
