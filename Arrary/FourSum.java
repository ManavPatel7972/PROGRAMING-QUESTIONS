import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        List<List<Integer>> res = fourSumOptimal(arr, target);

        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            res.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> fourSumBetter(int[] arr, int target) {

        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int req = target - arr[i] - arr[j] - arr[k];

                    if (s.contains(req)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], req);
                        Collections.sort(temp);
                        res.add(temp);
                    }

                    s.add(arr[k]);
                }
                s.clear();
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> fourSumOptimal(int[] arr, int target) {

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < arr.length; j++) {

                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int k = j + 1;
                int l = arr.length - 1;

                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum == target) {
                        res.add(Arrays.asList(arr[i], arr[j],
                                arr[k], arr[l]));

                        while (k < l && arr[k] == arr[k + 1]) {
                            k++;
                        }

                        while (k < l && arr[l] == arr[l - 1]) {
                            l--;
                        }

                        l++;
                        k--;
                    }

                    else if (sum < target)
                        l++;
                    else
                        k--;

                }
            }
        }

        return new ArrayList<>(res);
    }

}