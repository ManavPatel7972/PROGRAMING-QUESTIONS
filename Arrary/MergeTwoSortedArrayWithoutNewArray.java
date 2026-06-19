import java.util.Arrays;

public class MergeTwoSortedArrayWithoutNewArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        int m = 3, n = 3;

        mergeOptimal(nums1,m, nums2,n);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }


    public static void merge(int[] n1, int[] n2){
        int n = n1.length;
        
        for(int i = 0; i < n; i++) {

            if(n1[i] > n2[0]) {

                int temp = n1[i];
                n1[i] = n2[0];
                n2[0] = temp;

                Arrays.sort(n2);
            }
        }
    }

    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n){
        int left = m-1;
        int right = 0;

        while (left >=0 && right<n) {
            if(nums1[left] > nums2[right]){
                // swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
