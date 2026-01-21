package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio1792 {
    public static void main(String[] args) {
        MaximumAveragePassRatio1792 obj = new MaximumAveragePassRatio1792();
        int[][] classes = ArrayParser.parse2DArray("[[1,2],[3,5],[2,2]]");
        double ans = obj.maxAverageRatio(classes, 2);
        System.out.println(ans);
    }


    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Comparator<int[]> comparator = (a,b) -> {
            double diff1 = ((a[0] + 1.0)/( a[1] + 1.0)) - ((double) a[0]/a[1]);
            double diff2 = ((b[0] + 1.0)/( b[1] + 1.0)) - ((double) b[0]/b[1]);
            return Double.compare(diff2, diff1);
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        pq.addAll(Arrays.asList(classes));
        while (extraStudents != 0){
            int[] a = pq.poll();
            a[0] += 1;
            a[1] += 1;
            pq.offer(a);
            extraStudents--;
        }
        double avg = 0;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            avg += (double) a[0] /a[1];
        }

        return avg/classes.length;
    }
}
