import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("Res = " + findRelativeRanks(score));
    }

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        int[] sorted = score.clone();

        Arrays.sort(sorted);

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rank = n - i;

            if (rank == 1) {
                map.put(sorted[i], "Gold Medal");
            } else if (rank == 2) {
                map.put(sorted[i], "Silver Medal");
            } else if (rank == 3) {
                map.put(sorted[i], "Bronze Medal");
            } else {
                map.put(sorted[i], "" + rank);
            }
        }

        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            res[i] = map.get(score[i]);
        }

        return res;
    }
}
