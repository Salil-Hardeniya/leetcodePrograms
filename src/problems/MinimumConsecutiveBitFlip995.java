package problems;

public class MinimumConsecutiveBitFlip995 {
    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3));
    }

    //TODO - retry
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int flipCount = 0;
        int totalFlips = 0;

        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                flipCount ^= flip[i - k];
            }
            if (nums[i] == flipCount) {
                if (i + k > n) {
                    return -1; // If we can't flip the next k elements, return -1
                }
                flipCount ^= 1;
                flip[i] = 1;
                totalFlips++;
            }
        }

        return totalFlips;
    }
}
