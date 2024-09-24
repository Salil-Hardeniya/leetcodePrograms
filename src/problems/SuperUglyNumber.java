package problems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(99999,new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251}));
    }

//    public static int nthSuperUglyNumber(int n, int[] primes) {
//        PriorityQueue<Integer> ar = new PriorityQueue<>();
//        ar.add(1);
//        int[] res = new int[n];
//        res[0] = 1;
//        for (int i = 1; i < n; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int prime : primes) {
//                int cop = res[i - 1] * prime;
//                ar.offer(cop);
//                min = Math.min(min, cop);
//            }
//            res[i] = Math.min();
//        }
//        for(int i =0;i<n-1;i++){
//            ar.poll();
//        }
//        return ar.poll();
//    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> ar = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] res = new long[n];
        res[0] = 1;
        int i = 1;
        for (; i < n; i++) {
            for (int prime : primes) {
                long cop = res[i - 1] * prime;
                if(set.add(cop) && cop > 0)
                    ar.offer(cop);
            }
            res[i] = ar.poll();
        }
        return (int)res[n-1];
    }
}
