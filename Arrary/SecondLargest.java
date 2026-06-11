public class SecondLargest {
    public static void main(String[] args) {
       int[] arr1 = {1, 2, 4, 7, 7, 5};
        int n = arr1.length;

        int sL = secondLargest(arr1, n);

        System.out.println("Second Largest = "+ sL);
    }

    public static int secondLargest(int[] arr, int n){
        int fLarge = Integer.MIN_VALUE;
        int sLarge = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i] > fLarge){
                sLarge = fLarge;
                fLarge = arr[i];
            }
            
            else if(arr[i] != fLarge && arr[i]> sLarge){
                sLarge = arr[i];
            }
        }

        return sLarge;


    }
}
