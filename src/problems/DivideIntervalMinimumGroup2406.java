package problems;

/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group,
 and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
*/

import java.util.*;

public class DivideIntervalMinimumGroup2406 {
    public static void main(String[] args) {
        DivideIntervalMinimumGroup2406 divideIntervalMinimumGroup2406 = new DivideIntervalMinimumGroup2406();
        int[][] array = ArrayParser.parse2DArray("[[1, 2], [3, 4], [5, 6], [7, 8], [9, 10]]");
        System.out.println(Arrays.deepToString(array));
        int ans = divideIntervalMinimumGroup2406.minGroups(array);
        System.out.println(ans);
    }

// OLD getting TLE
//    public int minGroups(int[][] intervals) {
//        Comparator<int[]> comparator = (a,b) -> {
//            if(a[0] != b[0]){
//                return Integer.compare(a[0], b[0]);
//            }
//            else {
//                return Integer.compare(a[1], b[1]);
//            }
//        };
//        Arrays.sort(intervals, comparator);
//        List<List<Integer>> rangeCount = new ArrayList<>();
//        outer : for(int[] ar : intervals){
//            for(List<Integer> range : rangeCount){
//                if(range.getLast() < ar[0]){
//                    range.removeLast();
//                    range.add(ar[1]);
//                    continue outer;
//                }
//            }
//            rangeCount.add(new ArrayList<>(List.of(ar[0], ar[1])));
//        }
//        return rangeCount.size();
//    }

    public int minGroups(int[][] intervals) {
        Comparator<int[]> comparator = (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }
        };
        Arrays.sort(intervals, comparator);
        PriorityQueue<Integer> rangeCount = new PriorityQueue<>();
        for(int[] ar : intervals){
            if (!rangeCount.isEmpty() && rangeCount.peek() < ar[0]) {
                rangeCount.poll();
            }
            rangeCount.add(ar[1]);
        }
        return rangeCount.size();
    }
}
