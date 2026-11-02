public class NumberOf1Bits {
    public static void main(String[] args) {

    }

    public static int numberOfOneBits(int n) {
        if (n == 0) {
            return 0;
        }

        String bin = convertToBinary(n);
        int bit = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                bit++;
            }
        }
        return bit;
    }

    public static String convertToBinary(int num) {
        if (num == 0) {

            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remainder = num % 2;
            sb.append(remainder);
            num = num / 2;
        }

        return sb.reverse().toString();
    }
}
