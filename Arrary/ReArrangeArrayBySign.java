import java.util.ArrayList;
import java.util.List;

public class ReArrangeArrayBySign {
    public static void main(String[] args) {
        int[] A = {3,1,-2,-5,2,-4};
        int n = A.length;

       
        int[] result = rearrangeBySign(A, n);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] rearrangeBySign(int[] arr, int n){
        int[] temp = new int[arr.length];
        int pos = 0;
        int neg = 1;

        for (int i = 0; i < temp.length; i++) {
            if(arr[i] > 0){
                temp[pos] = arr[i];
                pos = pos + 2;
            }
            else if(arr[i] < 0){
                temp[neg] = arr[i];
                neg = neg + 2;
            }
        }

        return temp;
    }

    // BRUTE
    public int[] rearrangeBySign2(int[] A, int n) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            if (A[i] > 0)
                pos.add(A[i]); 
            else
                neg.add(A[i]);
        }

       
        for (int i = 0; i < n / 2; i++) {
            A[2 * i] = pos.get(i);      
            A[2 * i + 1] = neg.get(i); 
        }

        return A;
    }
}
