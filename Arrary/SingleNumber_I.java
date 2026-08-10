import java.util.Arrays;

public class SingleNumber_I {
    public static void main(String[] args) {

    }

    public static int single(int[] arr) {
        Arrays.sort(arr);

        if (arr.length == 1)
            return arr[0];

        for (int i = 0; i < arr.length - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }

        return arr[arr.length - 1];
    }
}
