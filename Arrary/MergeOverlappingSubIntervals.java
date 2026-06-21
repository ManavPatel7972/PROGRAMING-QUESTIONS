import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        List<List<Integer>> result = mergeOptimal(arr);
        System.out.println(result);
    }

    // public static List<List<Integer>> merge(int[][] arr) {

    //     // sort
    //     Arrays.sort(arr, (a, b) -> {
    //         if (a[0] != b[0]) {
    //             return Integer.compare(a[0], b[0]);
    //         }

    //         return Integer.compare(a[1], a[1]);
    //     });

    //     List<List<Integer>> res = new ArrayList<>();

    //     int n = arr.length;
    //     int i = 0;

    //     while (i < n) {
    //         int start = arr[i][0];
    //         int end = arr[i][1];

    //         int j = i + 1;

    //         while (j < n && arr[j][0] <= end) {
    //             end = Math.max(end, arr[j][1]);
    //             j++;
    //         }

    //         res.add(Arrays.asList(start, end));

    //         i = j;

    //     }

    //     return res;

    // }


    public static int[][] merge(int[][] arr) {

        // Sort
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> res = new ArrayList<>();

        int n = arr.length;
        int i = 0;

        while (i < n) {

            int start = arr[i][0];
            int end = arr[i][1];

            int j = i + 1;

            while (j < n && arr[j][0] <= end) {
                end = Math.max(end, arr[j][1]);
                j++;
            }

            res.add(new int[]{start, end});

            i = j;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static List<List<Integer>> mergeOptimal(int[][] arr) {

        // sort
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], a[1]);
        });

        List<List<Integer>> res = new ArrayList<>();

        for (int[] a : arr) {

            if (res.isEmpty() || res.get(res.size() - 1).get(1) < a[0]) {
                res.add(Arrays.asList(a[0], a[1]));
            } else {
                int last = res.size() - 1;
                int maxEnd = Math.max(res.get(last).get(1), a[1]);

                res.get(last).set(1, maxEnd);
            }
        }

        return res;

    }
}
