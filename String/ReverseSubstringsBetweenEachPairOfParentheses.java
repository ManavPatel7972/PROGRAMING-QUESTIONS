package String;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println("RES = " + reverse(s));
    }

    public static String reverse(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(sb.toString());
                sb = new StringBuilder();
            } else if (ch == ')') {
                sb.reverse();
                String prev = st.pop();

                sb = new StringBuilder(prev + sb);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
