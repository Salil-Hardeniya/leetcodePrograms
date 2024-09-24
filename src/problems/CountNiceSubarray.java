package problems;

public class CountNiceSubarray {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int st = 0;int ed = 0;
        int count = 0;
        int ans = 0;
        int lc = 0;int rc = 0;
        while(st<=ed && ed<nums.length){
            if(nums[ed] % 2 == 0){
                if(count == k){
                    ++rc;
                }
                ++ed;
                continue;
            }
            ++count;
            ++ed;
            if(count == k+1){
                while(count == k+1){
                    if(nums[st] % 2 == 0){
                        ++lc;
                    }
                    else{
                        --count;
                    }
                    ++st;
                }
                ans += lc + rc + lc*rc;
                ++ans;
                rc = 0;
                lc = 0;
            }
        }
        if(count == k){
            while(count == k){
                if(nums[st] % 2 == 0){
                    ++lc;
                }
                else{
                    --count;
                }
                ++st;
            }
            ans += lc + rc + lc*rc;
            ++ans;
        }
        return ans;
    }
}
