public class LeftRotateEleByOne {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        rotateArrayByOne(nums);

        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotateArrayByOne(int[] arr){
        int first = arr[0];

        for(int i=1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = first;

    }
}
