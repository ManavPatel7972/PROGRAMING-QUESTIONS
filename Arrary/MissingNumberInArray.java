// ------------BRUT FORCE--------------

// public class MissingNumberInArray {
//     public static void main(String[] args) {
//         int arr[] = {8, 2, 4, 5, 3, 7, 1};

//         System.out.println("Missing = " + missing(arr));
//     }

//     public static int missing(int[] arr) {

//         for (int i = 1; i <= arr.length + 1; i++) {

//             int flag = 0;

//             for (int j = 0; j < arr.length; j++) {
//                 if (arr[j] == i) {
//                     flag = 1;
//                     break;
//                 }
//             }

//             if (flag == 0) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }


// ---------------BETTER----------------
// public class MissingNumberInArray {
//     public static void main(String[] args) {
//         int arr[] = {8, 2, 4, 5, 3, 7, 1};

//         System.out.println("Missing = " + missing(arr));
//     }

//     public static int missing(int[] arr) {

//         int[] hash = new int[arr.length + 2];

//         for (int i = 0; i < arr.length; i++) {
//             hash[arr[i]] = 1;
//         }

//         for (int i = 1; i < hash.length; i++) {
//             if (hash[i] == 0) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

// ---------------OPTIMAL----------------


 class MissingNumberInArray {
    public static void main(String[] args) {
        int arr[] = {8, 2, 6, 5, 3, 7, 1};

        System.out.println("Missing = " + missing(arr));
    }

    public static int missing(int[] arr) {

            int sum = 0;
         for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        int n = arr.length+1;
        int total = n * (n+1)/2;

        int res = total - sum;

        return res;

    }
}
