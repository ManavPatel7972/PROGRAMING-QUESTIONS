package Stack;

import java.util.Stack;

public class InfixToPrefix {
    public static void infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();

        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        s = sb.toString();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                // This works for most operators, but ^ is right-associative, while +, -, *, /
                // are left-associative.
                // For example:

                // A^B^C

                // should become:

                // ^A^BC
                while (!st.isEmpty()
                        && st.peek() != '('
                        && (getPriority(c) < getPriority(st.peek())
                                || (getPriority(c) == getPriority(st.peek()) && c != '^'))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        s = res.reverse().toString();

        System.out.println("Prefix = " + s);

    }

    public static int getPriority(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        return 0;
    }
}
