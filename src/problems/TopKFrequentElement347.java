package problems;

import java.util.*;

public class TopKFrequentElement347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,1,2,2,2,2,3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.putIfAbsent(n,0);
            map.computeIfPresent(n,(l,v) -> v+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> comp =
                (a,b) -> {
                    if(Objects.equals(a.getValue(), b.getValue())){
                        return a.getKey() - b.getKey();
                    }
                    else {
                        return b.getValue() - a.getValue();
                    }
                };
        list.sort(comp);
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
