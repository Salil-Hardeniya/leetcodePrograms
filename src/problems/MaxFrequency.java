package problems;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {
    public static void main(String[] args) {
        MaxFrequency maxFrequency = new MaxFrequency();
        int ans = maxFrequency.maxFreqSum("aeiaeia");
        System.out.println(ans);
    }

    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (k,v) -> v+1);
        }
        int vsum =0; int csum = 0;
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            char key = m.getKey();
            int count = m.getValue();
            if(key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u'){
                vsum = Math.max(vsum, count);
            }
            else{
                csum = Math.max(csum, count);
            }
        }
        return vsum + csum;
    }
}
