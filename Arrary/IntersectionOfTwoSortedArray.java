import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {

        int[] arr1 = {1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};

        int n = arr1.length;
        int m = arr2.length;
    
        List<Integer> Inter = findIntersection(arr1, arr2, n, m);
    
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Inter)
            System.out.print(val + " ");
    }

    public static List<Integer> findIntersection(int arr1[], int arr2[], int n, int m){
        int i=0,j=0;

        List<Integer> inter = new ArrayList<>();

        while (i< n && j< m) {

            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{
                inter.add(arr1[i]);
                i++;
                j++;
            }
        }

        return inter;
    }
}
