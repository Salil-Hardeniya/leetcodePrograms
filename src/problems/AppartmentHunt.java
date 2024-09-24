package problems;

import java.util.*;

public class AppartmentHunt {
    public static void main(String[] args) {
        List<Map<String, Boolean>> list = new ArrayList<>();
        Random random = new Random();
        for (int j = 0; j < 10; j++) {
            Map<String, Boolean> map = new HashMap<>();
            map.put("gym", random.nextBoolean());
            map.put("school", random.nextBoolean());
            map.put("store", random.nextBoolean());
            list.add(map);
        }
        System.out.println(list);
        String[] reqs = {"gym", "school", "store"};

        int x = findAppartment(list, reqs);

        System.out.println(x);
    }

        public static int findAppartment(List<Map<String, Boolean>> list, String[] req){
            Map<String, List<Integer>> nMap = new HashMap<>();

            for (Map<String, Boolean> map : list) {
                for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                    nMap.computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                            .add(entry.getValue() ? 1 : 0);
                }
            }

            int[] ar = new int[list.size()];

            for (List<Integer> l : nMap.values()) {
                int prev = 0, next = 0;
                for (int i = 0; i < l.size(); i++) {
                    int value = l.get(i);
                    if (value == 0) {
                        prev++;
                        next++;
                        l.set(i, next);
                    } else {
                        int c = -1;
                        for (int j = i - prev; j < i; j++) {
                            int temp = prev - ++c;
                            if (l.get(j) > temp) {
                                l.set(j, temp);
                            }
                        }
                        l.set(i, 0);
                        prev = 0;
                        next = 0;
                    }
                }
                for (int i = 0; i < l.size(); i++) {
                    ar[i] += l.get(i);
                }
            }

            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] < min) {
                    min = ar[i];
                    result = i;
                }
            }

            return result;
        }

}