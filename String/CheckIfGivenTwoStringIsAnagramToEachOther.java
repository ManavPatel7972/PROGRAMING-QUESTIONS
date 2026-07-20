package String;

import java.util.Arrays;

public class CheckIfGivenTwoStringIsAnagramToEachOther {
    public static void main(String[] args) {
        String s1 = "TEGERNI";
        String s2 = "integer";

        if (checkAnagramOptimal(s1, s2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        for (int i = 0; i < s1.length(); i++) {
            if (char1[i] != char2[i])
                return false;
        }

        return true;
    }

    public static boolean checkAnagramOptimal(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] hash = new int[26];

        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();

        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'A']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            hash[s2.charAt(i) - 'A']--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0)
                return false;
        }

        return true;
    }
}
