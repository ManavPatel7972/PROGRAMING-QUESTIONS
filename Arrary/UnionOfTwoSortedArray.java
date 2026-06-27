// --------------------------BRUT FORCE-------------

// import java.util.ArrayList;
// import java.util.List;
// import java.util.TreeMap;

// public class UnionOfTwoSortedArray {
//     public static void main(String[] args) {
//         int n = 10;
//         int m = 7;

//         int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//         int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

//         List<Integer> Union = findUnion(arr1, arr2, n, m);

//         System.out.println("Union of arr1 and arr2 is ");
//         for (int val : Union)
//             System.out.print(val + " ");

//     }

//     public static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m){

//         TreeMap<Integer, Integer> fre = new TreeMap<>();

//         for(int i=0;i<n;i++){
//             fre.put(arr1[i], fre.getOrDefault(arr1[i], 0)+1);
//         }

//         for(int i=0;i<m;i++){
//             fre.put(arr2[i], fre.getOrDefault(arr2[i], 0)+1);
//         }

//         List<Integer> uni = new ArrayList<>();

//         for(int key : fre.keySet()){
//             uni.add(key);
//         }
//         return uni;
//     }   
// }

// --------------------------OPTIMAL-------------

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };
        int n = arr1.length, m = arr2.length;

        List<Integer> result = findUnion(arr1, arr2, n, m);

        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result)
            System.out.print(val + " ");

    }

    public static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {

        List<Integer> uni = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (uni.isEmpty() || uni.get(uni.size() - 1) != arr1[i]) {
                    uni.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (uni.isEmpty() || uni.get(uni.size() - 1) != arr2[j]) {
                    uni.add(arr2[j]);

                }
                j++;
            } else {
                // Elements are equal add only ones (any i or j)
                if (uni.isEmpty() || uni.get(uni.size() - 1) != arr1[i]) {
                    uni.add(arr1[i]);
                    // Move both pointers

                }
                i++;
                j++;
            }
        }

        // Append remaining ele from arr1
        while (i < n) {
            if (uni.isEmpty() || uni.get(uni.size() - 1) != arr1[i]) {
                uni.add(arr1[i]);

            }
            i++;

        }

        while (j < m) {
            if (uni.isEmpty() || uni.get(uni.size() - 1) != arr2[j]) {
                uni.add(arr2[j]);

            }
            j++;

        }

        return uni;

    }
}
