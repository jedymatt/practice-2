
public class RomanNumeralConverter {

    private static char romanNumerals[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int input = sc.nextInt();
        System.out.println(convert(input));
    }

    public static String convert(int num) {
        String str = "";
        while (num > 0) {
            if (num >= 1000) {
                str += romanNumerals[6];
                num -= 1000;
            } else if (num >= 500) {
                if (num >= 900) {
                    str += romanNumerals[4];
                    str += romanNumerals[6];
                    num -= 900;
                    continue;
                }
                str += romanNumerals[5];
                num -= 500;
            } else if (num >= 100) {
                if (num >= 400) {
                    str += romanNumerals[4];
                    str += romanNumerals[5];
                    num -= 400;
                    continue;
                }
                str += romanNumerals[4];
                num -= 100;
            } else if (num >= 50) {
                if (num >= 90) {
                    str += romanNumerals[2];
                    str += romanNumerals[4];
                    num -= 90;
                    continue;
                }
                str += romanNumerals[3];
                num -= 50;
            } else if (num >= 10) {
                if (num >= 40) {
                    str += romanNumerals[2];
                    str += romanNumerals[3];
                    num -= 40;
                    continue;
                }
                str += romanNumerals[2];
                num -= 10;
            } else if (num >= 5) {
                if (num >= 9) {
                    str += romanNumerals[0];
                    str += romanNumerals[2];
                    num -= 9;
                    continue;
                }
                str += romanNumerals[1];
                num -= 5;
            } else {
                if (num >= 4) {
                    str += romanNumerals[0];
                    str += romanNumerals[1];
                    num -= 4;
                    continue;
                }
                str += romanNumerals[0];
                num -= 1;
            }

        }
        return str;
    }
}
