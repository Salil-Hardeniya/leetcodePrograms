package problems;

import java.util.Arrays;

public class MinMaxRangeBinary {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));

    }

    public static int[] searchRange(int[] nums, int target) {
        int s = 0;int e = nums.length - 1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(target == nums[mid]){
                int i = mid;
                while( i < nums.length && nums[i] == target){
                    i++;
                }
                int j = mid;
                while(j >= 0 && nums[j] == target){
                    j--;
                }
                return new int[]{j+1,i-1};
            }
            else if(target < nums[mid]){
                e = mid -1;
            }
            else{
                s = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
