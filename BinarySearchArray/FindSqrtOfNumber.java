public class FindSqrtOfNumber {
    public static void main(String[] args) {
        int n = 28;
        System.out.println("SQRT = " + sqrtOptimal(n));
    }

    public static int sqrtBrute(int n) {
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            if (i * i <= n)
                ans = i;

            else
                break;
        }

        return ans;
    }

    public static int sqrtOptimal(int n) {
        if (n < 2)
            return n;

        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid * mid) <= n) {

                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

}
