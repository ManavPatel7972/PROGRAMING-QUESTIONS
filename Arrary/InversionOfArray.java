public class InversionOfArray {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println();
        int inversions = numberOfInversionsOptimal(arr);
        System.out.println("The number of inversions is: " + inversions);
    }

    public static int numberOfInversions(int[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static int numberOfInversionsOptimal(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high)
            return cnt;

        int mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);

        cnt += mergeSort(arr, mid + 1, high);

        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

}
