public class SumOfSquaresOfSpecialElement {
    public static void main(String[] args) {
        System.out.println("Res = " + sumOfSquares(new int[] { 1, 2, 3, 4 }));
    }

    public static int sumOfSquares(int[] arr) {
        int res = 0;
        int n = arr.length;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res += (arr[i - 1] * arr[i - 1]);
            }
        }
        return res;
    }

    public static int sumOfSquaresMethod2(int[] arr) {
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (n % (i + 1) == 0) {
                res += Math.pow(arr[i], 2);
            }
        }

        return res;
    }
}