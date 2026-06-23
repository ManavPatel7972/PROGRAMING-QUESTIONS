public class FloorAndCeil {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10};
        int x = 5;
        int[] res = getFloorAndCeil(arr, x);
        System.out.println("The floor and ceil are: " + res[0] + " " + res[1]);
    }

    public static int[] getFloorAndCeil(int[] arr, int x) {
        int f = findFloor(arr, x);
        int c = findCeil(arr, x);

        return new int[]{f,c};
    }

    public static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }

    public static int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}
