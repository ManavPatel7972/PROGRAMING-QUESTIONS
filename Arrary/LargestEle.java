public class LargestEle {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 0};
        int n = arr1.length;

        int max = largest(arr1, n);

        System.out.println("Largest = "+ max);
    }


    public static int largest(int[] a, int n){
        int max = a[0];

        for(int i=1;i<n;i++){
            if(a[i]> max){
                max = a[i];
            }
        }

        return max;
    }
}
