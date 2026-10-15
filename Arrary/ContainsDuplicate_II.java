import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicate_II {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 1 };
        System.out.println("Res = " + isDuplicate(arr, 3));
    }

    public static boolean isDuplicate(int[] arr, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        for (List<Integer> idx : map.values()) {

            for (int i = 0; i < idx.size(); i++) {

                for (int j = i + 1; j < idx.size(); j++) {
                    if (Math.abs(idx.get(i) - idx.get(j)) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isDuplicateOptimize(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {

                int prevIdx = map.get(arr[i]);

                if (i - prevIdx <= k) {
                    return true;
                }
            }

            map.put(arr[i], i);
        }

        return false;
    }
}