package String;

public class NthDigit {

    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {

        int number = 1;

        while (n > 0) {

            String s = String.valueOf(number);

            if (n <= s.length()) {
                return s.charAt(n - 1) - '0';
            }

            n = n - s.length();
            number++;
        }

        return -1;
    }

    // public int nthDigitMethod2(int n) {
    //     String seq = "";

    //     for (int i = 1; seq.length() < n; i++) {
    //         seq = seq + i;
    //     }

    //     return seq.charAt(n - 1) - '0';

    // }

}