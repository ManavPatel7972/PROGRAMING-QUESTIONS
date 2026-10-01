public class CountBits {
    public static void main(String[] args) {
        int n = 5;
        int[] res = countBitsLeetCode(n);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] countBitsLeetCode(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i / 2] + (i % 2);
        }
        return arr;
    }

    public static int[] countBits(int n) {

        int[] ones = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            String binary = decimalToBinary(i);
            ones[i] = countOne(binary);
        }

        return ones;
    }

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder str = new StringBuilder();

        while (n > 0) {
            int rem = n % 2;
            str.insert(0, rem);
            n = n / 2;
        }

        return str.toString();
    }

    public static int countOne(String s) {
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one += 1;
            }
        }

        return one;
    }
}
