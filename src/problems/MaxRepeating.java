package problems;

import java.util.Arrays;

public class MaxRepeating {

    public static void main(String[] args) {
        System.out.println(maxRepeating("aaa", "a"));
    }

    public static int maxRepeating(String sequence, String word) {
        if(sequence.length() < word.length()) return 0;
        if(sequence.equals(word)) return 1;
        String[] ar =  sequence.split(word, -1);
        System.out.println(ar.length);
        System.out.println(Arrays.toString(ar));
        int max = 0;
        int c = 0;
        int i;
        for(i = 0;i<ar.length;i++){
            if(ar[i].equals("")){
                ++c;
            }else{
                break;
            }
        }
        max = c;
        c = 0;
        int j;
        for(j= ar.length-1;j>i;j--){
            if(ar[j].equals("")){
                ++c;
            }else{
                break;
            }
        }
        max = Math.max(max,c);
        c = 1;
        for(;i<j;i++){
            if(ar[i].equals("")){
                ++c;
            }else{
                max = Math.max(max,c);
                c = 1;
            }
        }

        return max;
    }
}
