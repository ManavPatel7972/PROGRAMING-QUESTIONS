public class MovesZerosAtEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);

        // Print the result
        System.out.print("Array after moving zeroes: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] arr){
        // pointer to first Zero
        int j = -1;

        for(int i=0;i<arr.length;i++){
           if(arr[i] == 0){
                j = i;  
                break;    
            }
        }

        if(j == -1) return;

        for(int i=j+1; i<arr.length;i++){
            if(arr[i] !=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }

    }
}
