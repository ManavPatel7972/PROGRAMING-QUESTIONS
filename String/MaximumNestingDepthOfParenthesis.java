package String;

public class MaximumNestingDepthOfParenthesis {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Max Depth: " + maxDepth(s));
    }

    public static int maxDepth(String s) {
        int max = 0;
        int curr = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                curr++;
            else if (ch == ')')
                curr--;

            max = Math.max(max, curr);
        }

        return max;
    }
}
