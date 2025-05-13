package problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinDeletionW449 {
    public static void main(String[] args) {
        MinDeletionW449 minDeletionW449 = new MinDeletionW449();
        System.out.println(minDeletionW449.minDeletion("aabb", 2));
    }

    public int minDeletion(String s, int k) {
        HashMap<Character, Integer> map  = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.putIfAbsent(ch, 0);
            map.computeIfPresent(ch, (f,v) -> v+1);
        }

        if(map.size() <= k)
            return 0;

        List<Integer> fre = (List<Integer>) map.values();
        Collections.sort(fre);
        int ans = 0;
        int dis = map.size() - k;
        for(int i = 0;i< dis;i++){
            ans += fre.get(i);
        }
        return ans;
    }
}
