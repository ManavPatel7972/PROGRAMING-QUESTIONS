public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(maxProductOptimal(arr));
    }

    public static int maxProduct(int[] arr) {
        int maxProd = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int prod = 1;

            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                maxProd = Math.max(maxProd, prod);
            }
        }

        return maxProd;
    }

    public static int maxProductOptimal(int[] arr) {
        int n = arr.length;

        int pre = 1, suf = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (pre == 0)
                pre = 1;

            if (suf == 0)
                suf = 1;

            pre *= arr[i];
            suf *= arr[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suf));
        }

        return ans;
    }
}
