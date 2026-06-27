public class SecondSmallest {
    public static void main(String[] args) {
       int[] arr1 = {1, 2, 4, 7, 7, 5};
        int n = arr1.length;

        int sL = secondSmallest(arr1, n);

        System.out.println("Second Smallest = "+ sL);
    }

    public static int secondSmallest(int[] arr, int n){
        int fSmallest = Integer.MAX_VALUE;
        int sSmallest = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i] < fSmallest){
                sSmallest = fSmallest;
                fSmallest = arr[i];
            }
            
            else if(arr[i] != fSmallest && arr[i] < sSmallest){
                sSmallest = arr[i];
            }
        }

        return sSmallest;

    }
}
