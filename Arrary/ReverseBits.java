public class ReverseBits {

    public static void main(String[] args) {

        int n = 43261596;

        int reversed = reverseBits(n);

        System.out.println("Input: " + n);
        System.out.println("Output: " + reversed);
    }

    public static int reverseBits(int n) {

        if (n == 0) {
            return 0;
        }

        String binary = convertToBinary(n);

        System.out.println("B ===" + binary);
        // make binary 32 bits
        while (binary.length() < 32) {
            binary = "0" + binary;
        }

        String reversedBinary = new StringBuilder(binary).reverse().toString();

        int decimal = convertToDecimal(reversedBinary);

        System.out.println("Binary: " + binary);
        System.out.println("Reversed Binary: " + reversedBinary);

        return decimal;
    }

    public static String convertToBinary(int n) {

        if (n == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (n > 0) {

            int rem = n % 2;

            sb.append(rem);

            n = n / 2;
        }

        return sb.reverse().toString();
    }

    public static int convertToDecimal(String binary) {

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {

            char bit = binary.charAt(i);

            if (bit == '1') {

                decimal += Math.pow(2, binary.length() - 1 - i);
            }
        }

        return decimal;
    }
}