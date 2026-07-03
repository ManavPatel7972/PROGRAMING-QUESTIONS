public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 3 };
        int[] arr2 = { 2 };

        System.out.println("Median = " + findMedianSortedArraysOptimal(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                temp[k++] = arr1[i++];
            } else {
                temp[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            temp[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            temp[k++] = arr1[j++];
        }

        int size = temp.length;

        if (size % 2 == 1)
            return temp[size / 2];

        return (temp[size / 2] + temp[(size / 2) - 1]) / 2;

    }

    public static double findMedianSortedArraysOptimal(int[] arr1, int[] arr2) {

        int n1 = arr1.length, n2 = arr2.length;

        if (n1 > n2)
            return findMedianSortedArraysOptimal(arr2, arr1);

        int n = n1 + n2;

        int left = (n1 + n2 + 1) / 2; // left partition
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = arr1[mid1];
            }

            if (mid2 < n2) {
                r2 = arr2[mid2];
            }

            if (mid1 - 1 >= 0) {
                l1 = arr1[mid1 - 1];
            }

            if (mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {

                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }

            else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }

        }

        return 0;

    }
}

// class Solution {
//     public double findMedianSortedArrays(int[] arr1, int[] arr2) {
//         int n1 = arr1.length, n2 = arr2.length;

//         // Ensure arr1 is the smaller array for simplicity
//         if (n1 > n2)
//             return findMedianSortedArrays(arr2, arr1);

//         int n = n1 + n2;
//         int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
//         int low = 0, high = n1;

//         while (low <= high) {
//             int mid1 = (low + high) >> 1; // Calculate mid index for arr1
//             int mid2 = left - mid1; // Calculate mid index for arr2

//             int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

//             // Determine values of l1, l2, r1, and r2
//             if (mid1 < n1)
//                 r1 = arr1[mid1];
//             if (mid2 < n2)
//                 r2 = arr2[mid2];
//             if (mid1 - 1 >= 0)
//                 l1 = arr1[mid1 - 1];
//             if (mid2 - 1 >= 0)
//                 l2 = arr2[mid2 - 1];

//             if (l1 <= r2 && l2 <= r1) {
//                 // The partition is correct, we found the median
//                 if (n % 2 == 1)
//                     return Math.max(l1, l2);
//                 else
//                     return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
//             } else if (l1 > r2) {
//                 // Move towards the left side of arr1
//                 high = mid1 - 1;
//             } else {
//                 // Move towards the right side of arr1
//                 low = mid1 + 1;
//             }
//         }

//         return 0; // If the code reaches here, the input arrays were not sorted.
//     }
// }