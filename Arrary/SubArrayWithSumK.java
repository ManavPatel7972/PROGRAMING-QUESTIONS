import java.util.HashMap;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;

        System.out.println("Count = " + subArrayCountOptimal(arr, k));
    }

    public static int subArrayCountBrute(int[] arr, int k) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;

                for (int temp = i; temp <= j; temp++) {
                    sum += arr[temp];
                }

                if (sum == k)
                    cnt++;

            }
        }

        return cnt;
    }

    public static int subArrayCountBetter(int[] arr, int k) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k)
                    cnt++;

            }
        }

        return cnt;
    }

    public static int subArrayCountOptimal(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int cnt = 0;

        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            int temp = preSum - k;

            if (map.containsKey(temp)) {
                cnt += map.get(temp);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }
}
