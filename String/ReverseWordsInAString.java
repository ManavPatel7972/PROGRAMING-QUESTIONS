package String;

import java.util.Stack;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "My Name Is";

        System.out.println("Result = " + reverseWordOptimal(s));
    }

    public static String reverseWord(String s) {
        Stack<String> stack = new Stack<>();
        String[] words = s.split(" ");

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (!stack.isEmpty()) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static String reverseWordOptimal(String s) {

        StringBuilder res = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int end = i;

            if (i < 0)
                break;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            String word = s.substring(i + 1, end + 1);

            if (res.length() > 0) {
                res.append(" ");
            }

            res.append(word);
        }

        return res.toString();

    }
}
