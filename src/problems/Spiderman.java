package problems;

public class Spiderman {
    static int[] dp;
    static int max;
    public static void main(String[] args) {
        int n= 6;
        int x= 10, y=1000, z = 3;
        dp = new int[2 * 100000];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(x,y);
        max  = n;

        minCost(n, x, y, z);

        System.out.println(dp[n]);
    }
    private static void minCost(int N, int x, int y, int z) {

        for (int i = 3; i <= N; i++) {
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2] + x, dp[i-1] + y);
            } else {
                dp[i] = Math.min(dp[i-1] + y, dp[(i+1)/2] + x + z);
            }
        }
    }

}


