package problems;

public class RotatedBinarySearch33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(search(nums, 8));
    }
    //TODO: Fix the code
    public static int search(int[] nums, int target) {
        int s = 0; int e = nums.length - 1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                if(nums[s] == target)
                    return s;
                if(nums[s] > target){
                    s = mid+1;
                }
                else{
                    e = mid-1;
                }
            }
            else{
                if(nums[e] == target)
                    return e;
                if(nums[e] > target){
                    s = mid+1;
                }
                else{
                    e = mid-1;
                }
            }
        }
        return -1;
    }
}
