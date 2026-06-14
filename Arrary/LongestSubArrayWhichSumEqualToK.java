public class LongestSubArrayWhichSumEqualToK {
    public static void main(String[] args) {

        int[] arr = {1,2,3,1,1,1,1,4,2,3};

        System.out.println("Longest = " + optimal(arr, 3));
        
    }

    public static int find(int[] arr,int k){
        
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                
                sum += arr[j];

                if(sum == k){
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;

    } 

    // OPTIMAL
    public static int optimal(int[] arr, int k){

        int i = 0, j = 0, maxLen = 0;
        int sum = arr[0];
        int n = arr.length;

        while (i < n) {
            

            while (j <= i && sum > k) {
                sum -= arr[j];
                j++;
            }

            if(sum == k){
                maxLen = Math.max(maxLen, i-j+1);
            }

            i++;

            if(i < n) sum += arr[i];
        }


        return maxLen;
    }
}
