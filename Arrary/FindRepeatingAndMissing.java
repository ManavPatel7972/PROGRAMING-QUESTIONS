import java.util.Arrays;

public class FindRepeatingAndMissing {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 4, 6, 7, 5 };
        int[] result = findMissingRepeatingNumbersOptimal(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] findMissingRepeatingNumbersBrute(int[] arr) {
        int n = arr.length;
        int repeat = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] == i)
                    cnt++;
            }

            if (cnt == 2)
                repeat = i;

            else if (cnt == 0)
                missing = i;

            if (repeat != -1 && missing != -1)
                break;

        }

        return new int[] { repeat, missing };
    }

    public static int[] findMissingRepeatingNumbersBetter(int[] arr) {

        int[] hash = new int[arr.length + 1];

        int repeat = 1, missing = -1;

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2)
                repeat = i;
            else if (hash[i] == 0)
                missing = i;

            if (repeat != -1 && missing != -1)
                break;
        }

        return new int[] { repeat, missing };

    }

    public static int[] findMissingRepeatingNumbersOptimal(int[] arr) {

        int n = arr.length;
        int sn = (n * (n + 1)) / 2;
        int sn2 = (n * (n + 1) * (2 * n + 1)) / 6;

        int S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += arr[i] * arr[i];
        }

        int val1 = S - sn;
        int val2 = S2 - sn2;

        val2 = val2 / val1;
        int x = (val1 + val2) / 2;
        int y = x - val1;

        return new int[]{x,y};

    }

}
