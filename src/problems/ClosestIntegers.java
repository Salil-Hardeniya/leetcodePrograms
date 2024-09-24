package problems;

import java.util.*;
import java.util.stream.Collectors;

public class ClosestIntegers {

    public static void main(String[] args) {
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 3, 4));
        List<Integer> ar = new ArrayList<>(List.of(1,2,3,4,5));
        Integer x = 6;
        ar.remove(x);
    }



    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int e = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        int les = 0, mor = 0;
        if(x < arr[0]){
            les = - 1; mor = 0;
        }
        else if(x > arr[e]){
            les = e; mor = e + 1;
        }
        else{
            for(int i = 0; i<arr.length;i++){
                if(x > arr[i])
                    continue;
                    else if (x == arr[i]){
                        res.add(arr[i]);
                        k--;
                        les = i - 1;
                        mor = i+1;
                        break;
                    }
                else {
                    les = i -1;
                    mor = i;
                    break;
                }
            }
        }
        while(k != 0 && les > -1 && mor < arr.length){
            int t1 = Math.abs(x-arr[les]);
            int t2 = Math.abs(x-arr[mor]);
            if(t1 == t2){
                res.add(arr[les--]);
            }
            else if(t1 < t2){
                res.add(arr[les--]);
            }
            else{
                res.add(arr[mor++]);
            }
            k--;
        }
        while(k != 0){
            if(les == -1){
                res.add(arr[mor++]);
            }
            else{
                res.add(arr[les--]);
            }
            k--;
        }

        Collections.sort(res);
        return res;
    }
}
