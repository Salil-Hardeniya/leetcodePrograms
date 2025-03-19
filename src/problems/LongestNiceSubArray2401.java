package problems;

public class LongestNiceSubArray2401 {
    public static void main(String[] args) {
        LongestNiceSubArray2401 longestNiceSubArray2401 = new LongestNiceSubArray2401();
        int[] nums = {1,3,8,48,10};
        int ans = longestNiceSubArray2401.longestNiceSubarray(nums);
        System.out.println(ans);
    }

    public int longestNiceSubarray(int[] nums) {
        int left = 0; int right = 0;
        int currentbitOR = 0;
        int ans = 0;
        while (right < nums.length) {
            while ((currentbitOR & nums[right]) != 0) {
                currentbitOR ^= nums[left];
                left++;
            }

            currentbitOR |= nums[right];
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
