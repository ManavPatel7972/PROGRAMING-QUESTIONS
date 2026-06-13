public class CheckIfArrayIsShorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
    
        System.out.println(isSorted(arr, n) ? "True" : "False");
    }

    public static boolean isSorted(int[] arr, int n){

        int j=0;
        for(int i=1;i<n;i++){
            if(arr[j++] > arr[i]) return false;
        }

        return true;
        
    }
}
