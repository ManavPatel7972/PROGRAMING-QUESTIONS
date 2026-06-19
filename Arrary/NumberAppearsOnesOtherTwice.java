// BRUT FORCE

import java.util.HashMap;

public class NumberAppearsOnesOtherTwice {
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};

        System.out.println("Number = " + zorOptimal(arr));
    }

    public static int number(int[] arr){    
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int count = 0;

            for(int j=0;j<arr.length;j++){
                if(num == arr[j]) count++;
            }

            if(count == 1) return num;
        }

        return -1;
    }

    // BETTER

    public static int betterNumber(int[] arr){
        int max = arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int[] hash = new int[max + 1];

        for(int i=0;i<hash.length;i++){
            hash[arr[i]]++;
        }

        for(int i=0;i<hash.length;i++){
            if(hash[arr[i]] == 1) return arr[i];
        }
        
        return -1;

    }

    // OPTIMAL

    public static int optimalNumber(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();

          for(int i=0;i<arr.length;i++){
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

          }

          for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]) == 1) return arr[i];
          }

        return -1;
    }

    public static int zorOptimal(int[] arr){
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
}




