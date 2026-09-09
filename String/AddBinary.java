package String;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println("Result = " + addNumber(a, b));
    }

    public static String addNumber(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder s = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            s.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            s.append('1');
        }

        return s.reverse().toString();

    }
}
