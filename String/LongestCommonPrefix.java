package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = { "interview", "internet", "internal", "interval" };

        System.out.println("Result = " + longestPrefix(str));
    }

    public static String longestPrefix(String[] str) {
        StringBuilder res = new StringBuilder();

        Arrays.sort(str);

        String first = str[0];
        String last = str[str.length - 1];

        System.out.println(first);
        System.out.println(last);

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return res.toString();
            }

            res.append(first.charAt(i));
        }

        return res.toString();
    }
}
