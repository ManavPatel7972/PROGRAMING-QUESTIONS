public class NthRootOfNumber {
    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println("Nth Root = " + nThRootOptimal(n, m));
    }

    // time complexity = O(m);
    // space complexity = O(1); 
    public static int nThRootBrute(int n, int m) {
        for (int i = 1; i <= m; i++) {
            long power = (long) Math.pow(i, n);
            if (power == m)
                return i;

            if (power > m)
                break;
        }

        return -1;
    }

    // time complexity = O(log m);
    // space complexity = O(1);
    public static int nThRootOptimal(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if(ans > m) break;
            }

            if (ans == m) {
                return mid;
            }

            else if (ans < m)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}
