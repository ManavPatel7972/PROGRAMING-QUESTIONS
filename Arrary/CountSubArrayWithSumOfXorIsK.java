public class CountSubArrayWithSumOfXorIsK {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };

        int target = 6;
        System.out.println(countSubArraysXOR(arr, target));
    }

    public static int countSubArraysXOR(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            int xorVal = 0;

            for (int j = i; j < arr.length; j++) {

                xorVal  = xorVal ^ arr[j];

                if (xorVal == target) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
