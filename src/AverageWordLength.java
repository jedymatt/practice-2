
import java.util.Scanner;

public class AverageWordLength {

    //sample: The longest word in the dictionary is...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string_input = sc.nextLine();
        string_input = string_input.replaceAll("[^a-zA-Z0-9 ]", "");
        String[] array_input = string_input.split(" ");
        System.out.println(averageWordLength(array_input));
    }

    private static int averageWordLength(String[] string_array) {
        double value = 0;
        for (int i = 0; i < string_array.length; i++) {
            value += string_array[i].length();
        }
        return (int) Math.ceil(value / string_array.length);
    }
}
