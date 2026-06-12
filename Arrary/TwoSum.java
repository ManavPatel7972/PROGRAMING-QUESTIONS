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
}
