package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestSUbstringMinKRepeat {
    public static void main(String[] args) {
        System.out.println(longestSubstring("bchhbbdefghiaaacb",3));
    }

    public static int longestSubstring(String s, int k) {
        char[] car = s.toCharArray();
        return helper(car,k,0,s.length());
    }

    public static int helper(char[] car, int k, int st, int ed){
        if(ed - st < k)
            return 0;
        int[] count = new int[26];
        for(int i = st;i < ed;i++){
            int id = car[i] - 'a';
            count[id]++;
        }
        int mi = Integer.MAX_VALUE; char a = 'a';
        for(int i = 0;i < 26;i++){
            if(count[i] == 0)
                continue;
            if(count[i] < mi){
                mi = count[i];
                a = (char)('a' + i);
            }
        }
        if(mi >= k)
            return ed-st;
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(st-1);
        for(int i = st;i<ed;i++){
            if(car[i] == a)
                ar.add(i);
        }
        ar.add(ed);
        int res = 0;
        for(int i = 0;i<ar.size()-1;i++){
            res = Math.max(res, helper(car,k,ar.get(i)+1,ar.get(i+1)));
        }
        return res;
    }
}
