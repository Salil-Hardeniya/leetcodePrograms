package problems;

import java.util.HashMap;
import java.util.Map;

public class substringcontainingAllCharOFAnother {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.putIfAbsent(c,0);
            map.computeIfPresent(c,(k,v) -> v+1);
        }

        int st = 0; int ed = 0; int min = Integer.MAX_VALUE; int count = t.length();
        String res = "";
        while(ed < s.length()){
            char c = s.charAt(ed++);
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    --count;
                }
                map.put(c,map.get(c) - 1);
            }

            while(count == 0){
                char cc = s.charAt(st++);
                if(!map.containsKey(cc))
                    continue;

                min = Math.min(min, ed - st);
                if(min == ed-st){
                    res = s.substring(st-1,ed);
                }
                map.put(cc,map.get(cc) +1);
                if(map.get(cc) > 0){
                    count++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : res;
    }
}
