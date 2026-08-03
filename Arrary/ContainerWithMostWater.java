public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println("Max Water = " + maxArea(height));

    }

    public static int maxArea(int[] height) {

        int n = height.length;
        if (n == 0 || n == 1)
            return 0;

        int left = 0;
        int right = n - 1;

        int maxVal = 0;

        while (left <= right) {
            int diff = right - left;
            int min = Math.min(height[left], height[right]);
            maxVal = Math.max(maxVal, diff * min);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxVal;
    }
}
