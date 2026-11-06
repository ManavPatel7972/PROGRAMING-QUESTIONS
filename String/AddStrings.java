public class AddStrings {
    public static void main(String[] args) {
        String s1 = "456";
        String s2 = "77";

        String res = add(s1, s2);
        System.out.println("Res = " + res);
    }

    public static String add(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;r

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (i >= 0) {
                digit1 = s1.charAt(i) - '0';
            }

            if (j >= 0) {
                digit2 = s2.charAt(j) - '0';
            }

            int sum = digit1 + digit2 + carry;

            int lastDigit = sum % 10;
            carry = sum / 10;

            sb.append(lastDigit);

            i--;
            j--;

        }

        return sb.reverse().toString();

    }

    public static addStrings(String num1, String num2){
        
        StringBuilder str = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            sum = digit1 + digit2 + carry;
            str.append(sum % 10);
            carry = sum / 10;
        }

        return str.reverse().toString();
    }
}