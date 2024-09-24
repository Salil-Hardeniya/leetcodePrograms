package problems;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RangeInLists {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(-38, 15, 17, 18));
        nums.add(List.of(-34, 46, 58, 59, 61));
        nums.add(List.of(-55, -31, -13, 64, 82, 82, 83, 84, 85));
        nums.add(List.of(-3, 63, 70, 90));
        nums.add(List.of(2, 6, 10, 28, 28, 32, 32, 32, 33));
        nums.add(List.of(-23, 82, 88, 88, 88, 89));
        nums.add(List.of(33, 60, 72, 74, 75));
        nums.add(List.of(-5, 44, 44, 57, 58, 58, 60));
        nums.add(List.of(-29, -22, -4, -4, 17, 18, 19, 19, 19, 20));
        nums.add(List.of(22, 57, 82, 89, 93, 94));
        nums.add(List.of(24, 38, 45));
        nums.add(List.of(-100, -56, 41, 49, 50, 53, 53, 54));
        nums.add(List.of(-76, -69, -66, -53, -27, -1, 9, 29, 31, 32, 32, 32, 34));
        nums.add(List.of(22, 47, 56));
        nums.add(List.of(-34, -28, 7, 44));
        //[1, 5]
//        PriorityQueue<Element> p = new PriorityQueue<>((w1, w2) -> {
//            if(w1.val > w2.val)
//                return 1;
//            else if(w1.val < w2.val)
//                return -1;
//            return 0;
//        });

        Map<Integer, Integer> ar = new HashMap<>();
        for(Map.Entry<Integer, Integer> e : ar.entrySet()){
            int a = e.getValue();
            int b = e.getKey();
        }
        System.out.println(ar);
        Comparator<Element> comp = Comparator.comparingInt(a -> a.val);
        PriorityQueue<Element> p = new PriorityQueue<>(comp);

        int min   = Integer.MAX_VALUE;
        int max   = Integer.MIN_VALUE;
        int res = 0;
        for(List<Integer> list : nums){
            int temp = list.get(0);
            if(min > temp)
                min = temp;
            if(max < temp)
                max = temp;
            p.offer(new Element(list.get(0), nums.indexOf(list), 0));
        }
        int start = min;
        int end = max;
        res = max - min;
        while(!p.isEmpty()){
            Element e = p.peek();
            if(e.index < nums.get(e.listIndex).size() - 1){
                p.poll();
                p.offer(new Element(nums.get(e.listIndex).get(e.index() + 1), e.listIndex, e.index + 1));
                max = Math.max(max, nums.get(e.listIndex).get(e.index + 1));
                min = p.peek().val;
                if (max - min < res) {
                    res = max - min;
                    start = min;
                    end = max;
                }
            }
            else
                break;
        }

        System.out.printf("st = %d, end = %d\n", start, end);
        System.out.println(res);
    }
    

    public record Element(int val, int listIndex, int index) {
    }
}
