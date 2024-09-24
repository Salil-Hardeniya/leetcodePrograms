package problems;

import java.util.Arrays;

public class JumpGame2 { //45
    static Integer[] dp;
    public static void main(String[] args) {
//        System.out.println(jump(new int[]{2,1}));

        String s= "abcabqweababfababab1abababab";
        String s2 = "ab";
        String[] arr = s.split(s2, -1);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
    }
    public static int jump(int[] nums) {
        dp = new Integer[nums.length];
        dp[0] = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int temp = nums[i];
            for(int j = 1; j <= temp && (i + j) < nums.length; j++){
                if(dp[i + j] == null){
                    dp[i+j] = dp[i] + 1;
                }else{
                    dp[i+j] = Math.min(dp[i+j] , dp[i] + 1);
                }
            }
        }
        return dp[nums.length -1];
    }
}
