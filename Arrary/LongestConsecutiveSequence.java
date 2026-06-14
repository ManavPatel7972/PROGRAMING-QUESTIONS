import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr  = {100, 4, 200, 1, 3, 2};

        int ans = longestConsecutiveOptimal(arr);

        System.out.println("The longest consecutive sequence is " + ans);
    }

    public static int longestConsecutive(int[] arr){

        int longest = 1;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int cnt = 1;

            while (linearSearch(arr,x+1) == true) {
                x = x + 1;
                cnt += 1;
            }

            longest = Math.max(cnt,longest);

        }

        return longest;
    }

    public static boolean linearSearch(int[] arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x) return true;
        }
        return false;
    }

    public static int longestConsecutiveBetter(int[] arr){
        int lSmall = Integer.MIN_VALUE;
        int longest = 1;
        int cnt = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]-1 == lSmall){
                cnt += 1;
                lSmall = arr[i];
            }

            else if(arr[i] != lSmall){
                cnt = 1;
                lSmall = arr[i];
            }

            longest = Math.max(longest, cnt);

        }
        return longest;
    }

    public static int longestConsecutiveOptimal(int[] arr){
        Set<Integer> s = new HashSet<>();

        int n = arr.length;
        int longest = 1;

        if(n == 0) return 0;

        for (int i = 0; i < arr.length; i++) {
            s.add(arr[i]);
        }

        for (int it : s) {

            if(!s.contains(it -1)){
                int cnt = 1;
                int x = it;

                while (s.contains(x + 1)) {
                    cnt += 1;
                    x +=1;
                }

                longest = Math.max(cnt, longest);

            }
        }

        return longest;
    }


}