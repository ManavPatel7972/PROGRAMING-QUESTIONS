package Stack;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)"; // Infix expression
        System.out.println("Infix expression: " + exp);
        infixToPostfix(exp);
    }

    public static void infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' || c <= '9')) {
                res.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
            } else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        System.out.println("Postfix = " + res.toString());

    }

    public static int prec(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }
}
