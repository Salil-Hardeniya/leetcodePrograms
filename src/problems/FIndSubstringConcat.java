package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIndSubstringConcat { // to do

    public static void main(String[] args) {
        String s= "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));
//        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2}));
    }

    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int l = s.length();
        int wl = words[0].length();
        if(l < wl*words.length)
            return res;

        Map<String, Integer> count = new HashMap<>();
        for(String st : words){
            count.putIfAbsent(st,0);
            count.computeIfPresent(st,(k,v) -> v +1);
        }
        int c = words.length;
        int strt = 0;int e = 0;String temp;String temp1;
        while(e+wl<=l){
            temp = s.substring(e,e+wl);
            temp1 = s.substring(strt,strt+wl);
            if(count.containsKey(temp)){
                if(e - strt > wl * (words.length -1)){
                    if(count.containsKey(temp1)){
                        count.put(temp1,count.get(temp1)+1);
                        c++;
                    }
                    strt = strt + wl;
                    continue;
                }
                while(count.get(temp) == 0){
                    if(count.containsKey(temp1)){
                        count.put(temp1,count.get(temp1)+1);
                        c++;
                    }
                    strt = strt + wl;
                    temp1 = s.substring(strt,strt+wl);
                }
                if(count.get(temp) > 0){
                    count.put(temp,count.get(temp) -1);
                    c--;
                    if(c==0)
                        res.add(strt);
                }
                e = e+wl;
            }
            else{
                if(count.containsKey(temp1)){
                    count.put(temp1,count.get(temp1)+1);
                    c++;
                }

                e++;strt++;
            }
        }
        return res;
    }
}
