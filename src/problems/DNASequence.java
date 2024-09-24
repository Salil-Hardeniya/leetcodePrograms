package problems;

import java.util.*;

public class DNASequence {
    public static void main(String[] args) {
        String[] words= {"word","good","best","word"};
        Map<String, Integer> count = new HashMap<>();
        for(String s : words){
            count.putIfAbsent(s,0);
            count.computeIfPresent(s,(k,v) -> v +1);
        }

        System.out.println(count);


        String s= "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        int l = s.length();
        Set<String> res = new HashSet<>();
        Set<String> resul = new HashSet<>();
        res.add(s.substring(0,10));
        String abc;
        for( int e = 0;e <= l-10;e++){
            abc = s.substring(e,e+10);
            if(!res.add(abc))
                resul.add(abc);
        }
        System.out.println(resul);
    }
}
