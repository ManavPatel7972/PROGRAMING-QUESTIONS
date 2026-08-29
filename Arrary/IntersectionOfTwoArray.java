import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] num1 = { 1, 2, 2, 1 };
        int[] num2 = { 2, 2 };

        int[] res = intersection(num1, num2);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> li = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();

        for (int i : arr1) {
            s.add(i);
        }

        for (int i : arr2) {
            if (s.contains(i)) {
                li.add(i);
                s.remove(i);
            }
        }

        int[] res = new int[li.size()];
        int k = 0;

        for (int i : li) {
            res[k++] = i;
        }

        return res;
    }
}