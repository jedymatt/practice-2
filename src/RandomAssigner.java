
import java.util.*;
import java.io.*;

public class RandomAssigner {

    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();
        System.out.println("#Random Generator by Zed#\n");

        try {
            File file = new File("C:\\Users\\Jedy Matt\\Desktop\\Students.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                studentList.add(scanner.next());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Random rd = new Random();
        List<String> list = new ArrayList<>();
        int counter = 0;
        while (counter != 13) { // Adding randomly generated student
            int num = rd.nextInt(studentList.size());
            if (!list.contains(studentList.get(num))) {
                list.add(studentList.get(num));
                counter++;
            }
        }

        displayRandomSolo(list); // display

        list.clear();
        for (String i : list) {
            System.out.println(i);
        }
        List<String> checkList = new ArrayList<>();
        for (String i : checkList) {
            System.out.println(i);
        }

        counter = 0;
        while (counter != 8) { // adding randomly generated student
            int num1 = rd.nextInt(studentList.size());
            int num2 = rd.nextInt(studentList.size());

            if (num1 != num2) {

                if (!checkList.contains(studentList.get(num1)) && !checkList.contains(studentList.get(num2))) {
                    checkList.add(studentList.get(num1));
                    checkList.add(studentList.get(num2));
                    String pair = studentList.get(num1) + ", " + studentList.get(num2);

                    if (!list.contains(pair)) {
                        list.add(pair);
                        counter++;
                    }
                }

            }

        }

        System.out.println();
        displayRandomPair(list); // display
    }
    

    private static void displayRandomSolo(List<String> list) {
        System.out.println("[Random Assign: Solo]");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("s" + (i + 1) + " " + list.get(i));
        }
    }

    private static void displayRandomPair(List<String> list) {
        System.out.println("[Random Assign: Pair]");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("p" + (i + 1) + " " + list.get(i));
        }
    }

}
