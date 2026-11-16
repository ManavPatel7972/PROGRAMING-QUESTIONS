public class NumberOfSubArraysWithOddSum{
    public static void main(String[] args) {
        
    }

    public int numOfSubArrays(int[] arr) {

        int mod = 1000000007;

        long odd = 0;
        long even = 1;

        long sum = 0;
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum % 2 == 0) {

                ans += odd;
                even++;

            } else {

                ans += even;
                odd++;

            }

            ans %= mod;
        }

        return (int) ans;
    }
}