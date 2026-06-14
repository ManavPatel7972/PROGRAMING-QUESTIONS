public class MaximumConsecutiveOne {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1,1};

        System.out.println("MaximumConsecutiveOne = " + maximumConsecutiveOne(arr));
    }

    public static int maximumConsecutiveOne(int[] arr){

        int count = 0;
        int maxCount = 0;

    //    for(int i=0;i<arr.length;i++){

    //         if(arr[i]==1){
    //             count++;
    //             i++;
    //         }
    //         else{
    //             maxCount = Math.max(maxCount, count);
    //             count = 0;
    //         }
    //    }

    for (int i=0;i<arr.length;i++) {
        if(arr[i] == 1){
            count++;
            maxCount = Math.max(count,maxCount);
        }
        else{
            count = 0;
        }
    }

        return maxCount;
    }
}
