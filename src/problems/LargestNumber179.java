package problems;

import java.util.Arrays;

public class LargestNumber179 {
    public static void main(String[] args) {
        LargestNumber179 largestNumber179 = new LargestNumber179();
        String ans = largestNumber179.largestNumber(new int[]{3,30,34,5,9});
        System.out.println(ans);
    }

    public String largestNumber(int[] nums) {
        String[] st = new String[nums.length];
        int x = 0;
        for(int i : nums){
            st[x++] = String.valueOf(i);
        }
        Arrays.sort(st, (a,b) ->  (b+a).compareTo(a+b));
        if(st[0].equals("0"))
            return "0";
        StringBuilder str = new StringBuilder();
        for(String s : st){
            str.append(s);
        }
        return str.toString();
    }
}
