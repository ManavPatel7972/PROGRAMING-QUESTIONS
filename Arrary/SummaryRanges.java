import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        List<String> res = range(new int[] { 0, 1, 2, 4, 5, 7 });
        System.out.println(res.toString());
    }

    public static List<String> range(int[] arr) {

        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < arr.length) {

            int s = i;

            while (i + 1 < arr.length && arr[i + 1] == arr[i] + 1) {
                i++;
            }

            if (s == i) {
                res.add(arr[s] + "");
            } else {
                res.add(arr[s] + "->" + arr[i]);
            }

            i++;
        }

        return res;

    }
}