package problems;

import java.util.Arrays;

public class MaxOperationZeroBIW156 {
    public static void main(String[] args) {
        MaxOperationZeroBIW156 maxOperationZeroBIW156 = new MaxOperationZeroBIW156();
        int ans = maxOperationZeroBIW156.minOperations(new int[]{1,2,1,2,1,2});
        System.out.println(ans);
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        while(Arrays.stream(nums).sum() != 0){
            int l = 0;
            int min = Integer.MAX_VALUE;
            while(l < n && nums[l] == 0) l++;
            if(l == n)
                break;
            int r = l;
            while(r < n && nums[r] != 0){
                min = Math.min(min, nums[r]);
                r++;
            }
            for(int i = l;i<r;i++){
                if(nums[i] == min)
                    nums[i] = 0;
            }

            ans++;
            l = r;
        }
        return ans;
    }

}
