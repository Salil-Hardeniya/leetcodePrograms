package problems;

import java.util.Arrays;

public class NeetCodeLongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int count = 0;
        if(nums.length == 0)
            return 0;
        int prev = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == prev + 1){
                ++count;
            } else if(nums[i] == prev){
                continue;
            } else count = 0;
            prev = nums[i];
            ans = Math.max(ans, count);
        }
        return ans + 1;
    }
}
