import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityEleN3Times {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        
        List<Integer> ans = majorityElementTwo(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }

    public static List<Integer> majorityElementTwo(int[] arr){
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (result.size() == 0 || result.get(0) != arr[i] && (result.size() < 2 || result.get(1) != arr[i])) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }

                if (count > n / 3) {
                    result.add(arr[i]);
                }
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    public static List<Integer> majorityElementTwoBetter(int[] arr){

        List<Integer> res = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();

        int mini = arr.length / 3 + 1;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);

            if(map.get(arr[i]) == mini){
                res.add(arr[i]);
            }

            if(res.size() > 2) break;
        }

        return res;
        
    }
}
