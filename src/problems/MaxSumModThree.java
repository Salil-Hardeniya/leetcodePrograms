package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSumModThree {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
    }

    private static int maxSumDivThree(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(2, Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(2, Collections.reverseOrder());
        for(int n : nums){
            sum += n;
            if(n%3 == 1){
                addElement(pq1,n);
            } else if(n%3 == 2) {
                addElement(pq2,n);
            }
        }

        if(sum % 3 == 0)
            return sum;
        if(sum % 3 == 1){
            int s = Integer.MAX_VALUE;
            if(pq2.size() == 2){
                s = 0;
                for (int a : pq2){
                    s += a;
                }
            }
            if(!pq1.isEmpty()){
                sum -= Math.min(pq1.peek(),s);
            }
            else
                sum -= s;
        }
        else {
            int s = Integer.MAX_VALUE;
            if(pq1.size() == 2){
                s = 0;
                for (int a : pq1){
                    s += a;
                }
            }
            if(!pq2.isEmpty()){
                sum -= Math.min(pq2.peek(),s);
            }
            else
                sum -= s;
        }

        return sum;
    }

    public static void addElement(PriorityQueue<Integer> pq, int element) {
        pq.offer(element);
        if (pq.size() > 2)
            pq.poll();
    }


//    public static int maxSumDivThree(int[] nums) {
//        int sum3 = 0;
//        int sumT = 0;
//        List<Integer> ar = new ArrayList<>();
//        for(int i = 0;i<nums.length;i++){
//            int x = nums[i];
//            if(x %3 == 0)
//                sum3 +=x;
//            else {
//                sumT += x;
//                ar.add(x);
//            }
//        }
//        ar.sort(null);
//        int mod = sumT % 3;
//        if(mod == 1){
//            int del2 = 0;
//            int delcount = 0;
//            for(Integer a :  ar){
//                if(a%3 == 2){
//                    del2 += a;
//                    delcount++;
//                    if(delcount == 2){
//                        break;
//                    }
//                }
//            }
//            int del1 = 0;
//            for(Integer a :  ar){
//                if(a%3 == 1){
//                    del1 +=a;
//                    break;
//                }
//            }
//            if(delcount == 2 && del1 != 0)
//                sumT -= Math.min(del1,del2);
//            else if(delcount== 2)
//                sumT -=del2;
//            else
//                sumT -=del1;
//        }
//        else if(mod == 2){
//            int del1 = 0;
//            int delcount = 0;
//            for(Integer a :  ar){
//                if(a%3 == 1){
//                    del1 += a;
//                    delcount++;
//                    if(delcount == 2){
//                        break;
//                    }
//                }
//            }
//            int del2 = 0;
//            for(Integer a :  ar){
//                if(a%3 == 2){
//                    del2 +=a;
//                    break;
//                }
//            }
//            if(delcount == 2 && del2 != 0)
//                sumT -= Math.min(del1,del2);
//            else if(delcount== 2)
//                sumT -=del1;
//            else
//                sumT -=del2;
//        }
//
//        return sum3 + sumT;
//    }
}
