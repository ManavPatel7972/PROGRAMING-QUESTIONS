import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 5, 3, 1, 2 };

        List<Integer> ans = leader(arr);

        System.out.print("Leaders in the array are: ");
        for (int leader : ans) {
            System.out.print(leader + " ");
        }
    }

    public static List<Integer> leader(int[] arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> li = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                li.add(arr[i]);
                max = arr[i];
            }
        }
        
        Collections.reverse(li);
        return li;
    }
}
