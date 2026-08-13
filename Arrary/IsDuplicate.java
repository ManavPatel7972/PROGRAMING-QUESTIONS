import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsDuplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 43, 65, 75 };

        System.out.println("IsDuplicate Present = " + isDuplicate(arr));
    }

    public static boolean isDuplicate(int[] arr) {
        if (arr.length == 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i) && map.get(i) >= 1)
                return true;

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return false;
    }

    public static boolean isDuplicateSet(int[] arr) {
        if (arr.length == 0)
            return false;

        Set<Integer> s = new HashSet<>();

        for (int i : arr) {
            if (s.contains(i))
                return true;

            s.add(i);
        }

        return false;
    }
}