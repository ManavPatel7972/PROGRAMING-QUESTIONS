import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        
        List<List<Integer>> res = threeSumOptimal(arr, n);

        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] arr, int n){
        Set<List<Integer>> s = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1 ; k < arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        s.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(s);

    }

    public static List<List<Integer>> threeSumBetter(int[] arr, int n){

        Set<List<Integer>> s = new HashSet<>();
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length; j++) {
                // arr[i] + arr[j] + arr[k] == 0 
                // so arr[k] = -(arr[i] + arr[j]);
               int th = -(arr[i] + arr[j]);

               if(hs.contains(th)){
                List<Integer> temp = Arrays.asList(arr[i],arr[j], th);
                Collections.sort(temp);
                s.add(temp);
               }

               hs.add(arr[j]);
            }

            hs.clear();
        }

        return new ArrayList<>(s);

    }

    public static List<List<Integer>> threeSumOptimal(int[] arr, int n){
        // Sort 
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;

            int j = i+1;
            int k = arr.length-1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    res.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j-1]) {
                        j++;
                    }
                    while (j < k &&arr[k] == arr[k+1]) {
                        k--;
                    }
                }
            }

        }
        return res;
    }
}
