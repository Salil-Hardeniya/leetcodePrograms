package problems;

import java.util.Arrays;

public class HouseRobber198 {
    public static void main(String[] args) {
        HouseRobber198 hHouseRobber198 = new HouseRobber198();
        int ans = hHouseRobber198.rob(new int[]{2,7,9,3,1});
        System.out.println(ans);
    }

    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int y = nums[0] + rob(nums, 2);
        int n = rob(nums,1);

        return Math.max(y,n);
    }

    public int rob(int[] nums, int i){
        if(i >= nums.length)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int y = nums[i] + rob(nums, i+2);
        int n = rob(nums,i+1);
        dp[i] = Math.max(y,n);
        return dp[i];
    }

//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] memo = new int[nums.length + 1];
//        memo[0] = 0;
//        memo[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
//        }
//        return memo[nums.length];
//    }
}
