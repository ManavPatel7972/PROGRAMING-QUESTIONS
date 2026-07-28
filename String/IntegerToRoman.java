package String;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println("Result = " + intToRoman(num));
    }

    public static String intToRoman(int n) {

        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        String res = "";

        for (int i = 0; i < val.length; i++) {
            if (n == 0)
                break;

            int times = n / val[i];

            while (times != 0) {
                res += symbol[i];
                times--;
            }

            n = n % val[i];

        }

        return res;

    }
}
