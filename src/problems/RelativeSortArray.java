package problems;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
    }

        public static int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer,Integer> map = new HashMap<>();
            int k =0;
            for(int n : arr2){
                map.put(n,k++);
            }
            Comparator<Integer> comp = (a, b) ->{
                Integer x= map.getOrDefault(a,10000);
                Integer y= map.getOrDefault(b,10000);
                if(Objects.equals(x, y) && x == 10000){
                    return a.compareTo(b);
                }
                return x.compareTo(y);
            };
            arr1 = Arrays.stream(arr1).
                    boxed().
                    sorted(comp). // sort descending
                            mapToInt(i -> i).
                    toArray();
            return arr1;
        }
}
