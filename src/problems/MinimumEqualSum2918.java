package problems;

import java.util.Arrays;

public class MinimumEqualSum2918 {
    public static void main(String[] args) {
        MinimumEqualSum2918 minimumEqualSum2918 = new MinimumEqualSum2918();
        int[] nums1 = {1,2,3,2};
        int[] nums2 = {8};
        long ans = minimumEqualSum2918.minSum(nums1, nums2);
        System.out.println(ans);
    }

//    public long minSum(int[] nums1, int[] nums2) {
//        long sum1 = 0; int zero1 = 0;
//        for (int i : nums1) {
//            if(i == 0)
//                zero1++;
//            sum1 += i;
//        }
//        long sum2 = 0; int zero2 = 0;
//        for (int i : nums2) {
//            if(i == 0)
//                zero2++;
//            sum2 += i;
//        }
//        return Math.max(getAns(sum1, sum2, zero1, zero2), getAns(sum2, sum1, zero2, zero1));
//    }
//    public long getAns(long sum1, long sum2, int zero1, int zero2){
//        long diff = sum1 - sum2;
//        if(diff < 0 || (diff == 0 && ((zero1 != 0 && zero2 == 0) || (zero1 == 0 && zero2 != 0))))
//            return -1;
//        if(diff == 0){
//            return sum1 + Math.max(zero1, zero2);
//        }
//        if(zero2 == 0 || (zero1 == 0 && diff < zero2))
//            return -1;
//        if(zero1 == 0 && diff >= zero2){
//            return  sum1;
//        }
//        if(zero1 != 0 && diff < zero2){
//            return  Math.max(sum1 + zero1, sum2 + zero2);
//        }
//        if(zero1 != 0 && diff >= zero2){
//            return sum1 + zero1;
//        }
//
//
//        return -1;
//    }

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        long zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        long minSum1 = sum1+zeroCount1;
        long minSum2 = sum2+zeroCount2;

        if (minSum1<minSum2 && zeroCount1 == 0) {
            return -1;
        }

        if (minSum1>minSum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }

}
