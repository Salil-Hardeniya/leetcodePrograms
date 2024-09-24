package problems;

public class AverageWaitingTime1701 {
    public static void main(String[] args) {
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] cust) {
        int time = 0;
        long wait = 0;
        for (int[] ints : cust) {
            int orWait = Math.max(time - ints[0], 0);
            if (time - ints[0] < 0) {
                time = ints[0];
            }
            wait += orWait + ints[1];
            time += ints[1];
        }
        double ans = (double)wait;
        return ans/cust.length;
    }
}
