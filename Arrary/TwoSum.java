import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

         int[] res = hash(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    public static boolean twoSumExists(int[] arr,int target){

        for(int i=0;i<arr.length;i++){
            int num = arr[i];

            for(int j=i+1;j<arr.length;j++){
                if(arr[j] + num == target) return true; 
            }
        }

        return false;
    }

    public static int[] twoSumIndices(int[] arr, int target){

        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] + arr[i] == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] hash(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int more = target - a;

            if(map.containsKey(more)){
                return new int[] {map.get(more), i};
            }

            map.put(a,i);
        }

        return new int[]{-1,-1};
    }

    // time complexity: O(n) for hash map approach, O(n^2) for brute force approach.
    // space complexity: O(n) for hash map approach, O(1) for brute force approach.

    // /Third approach using two pointer technique:
    // 1. create a new array of Pair class which contains the value and index of the original array.
    // 2. sort the new array based on the value of the Pair class.
    // 3. left = 0, right  =  array length - 1
    // 4. while left < right, if sum == target, return the indices of the original array. if sum < target, left++, else right--.
    // 5. time complexity: O(nlogn) for sorting, O(n) for two pointer technique, so overall time complexity is O(nlogn).
    // space complexity: O(n) for new array of Pair class.
}
