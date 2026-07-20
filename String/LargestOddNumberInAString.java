package String;

public class LargestOddNumberInAString {
    public static void main(String[] args) {
        String num = "000156238540";

        System.out.println("Largest ODD = " + largestOdd(num));
    }

    public static String largestOdd(String s) {
        int idx = -1;

        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                idx = i;
                break;
            }
        }

        if (idx == -1)
            return "";

        // skip leading zero up to odd digit
        i = 0;

        while (i <= idx && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i, idx + 1);

    }
}
