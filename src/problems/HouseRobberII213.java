package problems;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected,
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.
*/

import java.util.Arrays;

public class HouseRobberII213 {
    public static void main(String[] args) {
        HouseRobberII213 hHouseRobber198 = new HouseRobberII213();
        int ans = hHouseRobber198.rob(new int[]{2,7,9,3,1});
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        return Math.max(
                robs(Arrays.copyOfRange(nums,0,nums.length-1)),
                robs(Arrays.copyOfRange(nums,1,nums.length))
        );
    }

        public int robs(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }
}
