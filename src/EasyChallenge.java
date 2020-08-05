
public class EasyChallenge {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = "";
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter anything: ");
            input = sc.nextLine().concat(System.getProperty("line.separator")).concat(input);
            System.out.println("Output:");
            input = input.trim();
            System.out.println(input);
        }
    }
}
