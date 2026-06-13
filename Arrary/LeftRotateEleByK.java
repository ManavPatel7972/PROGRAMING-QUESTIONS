// // ----------------------BRUT FORCE-----------------------------

// import java.util.Arrays;

// public class LeftRotateEleByK {
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5, 6, 7};
//         int k = 3;

//         rotateLeft(arr, k);
//         System.out.println("Array after left rotation: " + Arrays.toString(arr));
//     }

//     public static void rotateLeft(int[] arr,int k){
//         k = k % arr.length;
//         int[] temp = new int[k];
         
//         for(int i=0;i<k;i++){
//             temp[i] = arr[i];
//         }

//         for(int i=0;i<arr.length-k;i++){
//             arr[i] = arr[k+i];
//         }

//         int j = 0;
//         for(int i=arr.length-k;i<arr.length;i++){
//             arr[i] = temp[j++];
//         }
//     }
// }

// ----------------------OPTIMAL------------------

import java.util.Arrays;

public class LeftRotateEleByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 17;

        rotateLeft(arr, k);
        System.out.println("Array after left rotation: " + Arrays.toString(arr));
    }

    public static void rotateLeft(int[] arr,int k){

        k = k % arr.length;

       
        // Reverse of First part of k 
        reverse(arr, 0, k-1);

        // Reverse of First part of Remaining
        reverse(arr, k, arr.length-1);
        
        // reverse Hole part
        reverse(arr, 0, arr.length-1);

    }

    public static void reverse(int[] arr, int start, int end){

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}



