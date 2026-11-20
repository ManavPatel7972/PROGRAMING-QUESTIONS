public class MinimumScoreByChangingTwoElement {
    public static void main(String[] args) {
        Arrays.sort(nums);

        int n = nums.length;

        int ans1 = nums[n - 1] - nums[2];
        int ans2 = nums[n - 2] - nums[1];
        int ans3 = nums[n - 3] - nums[0];

        return Math.min(ans1, Math.min(ans2, ans3));
    }
}