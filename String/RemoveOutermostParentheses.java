package String;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";

        System.out.println("Result = " + removeOuter(s));

    }

    public static String removeOuter(String s) {
        String res = "";
        int cnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt += 1;
                if (cnt > 1) {
                    res += ch;
                }
            } else {
                cnt -= 1;
                if (cnt > 0) {
                    res += ch;
                }
            }
        }

        return res;
    }

}
