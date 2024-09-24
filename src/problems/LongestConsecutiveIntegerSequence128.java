package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveIntegerSequence128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        int ans = 0;
        for(int n : nums){
            if(set.contains(n-1))
                continue;
            int c = 1;
            while(set.contains(n+c))
                c++;
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
