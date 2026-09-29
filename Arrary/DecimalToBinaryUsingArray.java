public class DecimalToBinaryUsingArray {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Binary = " + decimalToBinary(n));
    }

    public static int decimalToBinary(int n) {

        int[] binary = new int[100];
        int i = 0;
        while (n > 0) {
            binary[i] = n % 2;
            n = n / 2;
            i++;
        }

        String num = "";
        for (int j = i - 1; j >= 0; j--) {
            num += binary[j];
        }

        int ans = Integer.parseInt(num);

        return ans;
    }
}
