import java.util.HashMap;

public class MajorityEleGreaterThanNby2 {
    public static void main(String[] args) {
         int[] arr = {2, 2, 1, 1, 1, 2, 2};
       
        int ans = optimal(arr);
        
        System.out.println("The majority element is: " + ans);
    }

    public static int majorityElement(int[] arr){
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            
            int cou = 0;

            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]) cou++;
            }

            if(cou > n/2) return arr[i];
        }

        return -1;
    }

    public static int usingMap(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if(map.get(key) > arr.length/2) return key;
        }

        return -1;
    }

    public static int optimal(int[] arr){

        int ele = -1;
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            if(c == 0) {
                c = 1;
                ele = arr[i];
            }
            else if(arr[i]== ele){
                c++;
            }
            else{
                c--;
            }
        }

        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ele) a++;
        }

        if(a > arr.length/2) return ele;
        
        return -1;
    }
}
