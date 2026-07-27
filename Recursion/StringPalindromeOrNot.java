package Recursion;

public class StringPalindromeOrNot {
    public static void main(String[] args) {
        String str = "MADAM";

        System.out.println("Is Palindrome = " + isPalindrome(str, 0));
    }

    public static boolean isPalindrome(String str, int i) {

        if (i >= str.length() / 2)
            return true;

        if (str.charAt(i) != str.charAt(str.length() - i - 1))
            return false;

        return isPalindrome(str, i + 1);

    }
}
