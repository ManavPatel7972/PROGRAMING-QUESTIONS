public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {9, 5, 10, 3, 12};
        int k = 10;

        System.out.println("Index For " + k + " = " + search(arr,k));
    }

    public static int search(int[] arr, int k){

        for(int i=0;i<arr.length;i++){
            if(arr[i] == k) return i;
        }
        
        return -1;
    }
}
