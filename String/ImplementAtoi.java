public class ImplementAtoi {

    static final int INT_MIN_VAL = -2147483648;
    static final int INT_MAX_VAL = 2147483647;

    public static void main(String[] args) {
        String s = "   -12345";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s.length() == 0)
            return 0;

        s = s.trim();

        if (s.length() == 0)
            return 0;

        int sign = +1;
        long ans = 0;

        if (s.charAt(0) == '-')
            sign = -1;

        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

        // initialized i pointer
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i)))
                break;

            ans = ans * 10 + s.charAt(i) - '0';

            if (sign == -1 && -1 * ans < MIN)
                return MIN;
            if (sign == 1 && 1 * ans > MAX)
                return MAX;

            i++;
        }

        return (int) (sign * ans);

    }

    static int helper(String s, int i, long num, int sign) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int) (sign * num);

        num = num * 10 + (s.charAt(i) - '0');

        if (sign * num <= INT_MIN_VAL)
            return INT_MIN_VAL;
        if (sign * num >= INT_MAX_VAL)
            return INT_MAX_VAL;

        // Recurse
        return helper(s, i + 1, num, sign);
    }

    static int myAtoiRec(String s) {
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        return helper(s, i, 0, sign);
    }
}
