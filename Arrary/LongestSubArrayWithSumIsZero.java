import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumIsZero {
    public static void main(String[] args) {
        int[] arr = new int[] { 9, -3, 3, -1, 6, -5 };
        System.out.println(cntSumZero(arr));
    }

    public static int cntSumZero(int[] arr) {

        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            else if (map.containsKey(sum)) {

                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;

    }
}
