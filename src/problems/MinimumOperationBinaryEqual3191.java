package problems;

public class MinimumOperationBinaryEqual3191 {
    public static void main(String[] args) {
        MinimumOperationBinaryEqual3191 minimumOperationBinaryEqual3191 = new MinimumOperationBinaryEqual3191();
        int[] nums = {0,1,1,1};
        int ans = minimumOperationBinaryEqual3191.minOperations(nums);
        System.out.println(ans);
    }

    public int minOperations(int[] nums) {
        int count = 0;
        for(int i =0;i< nums.length;i++){
            if(nums[i] == 1)
                continue;
            if(i+1 >= nums.length || i+2 >= nums.length)
                return -1;
            nums[i+1] ^= 1;
            nums[i+2] ^= 1;
            count++;

        }
        return count;
    }
}
