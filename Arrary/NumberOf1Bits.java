public class NumberOf1Bits {
    public static void main(String[] args) {

    }

    public int numberOfOneBits(int n) {
        if (n == 0) {
            return 0;
        }

        String bin = Integer.toBinaryString(n);
        int bit = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                bit++;
            }
        }
        return bit;
    }
}
