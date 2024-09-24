package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> words = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreaks(s,words));
    }

    static Boolean[] dp;
    public static boolean wordBreaks(String s, List<String> words) {
        if("".equals(s))
            return true;
        dp = new Boolean[s.length()];
        breaks(s,words,0);
        return dp[0];
    }

    static boolean breaks(String s, List<String> words, int idx){
        if(idx >= s.length())
            return true;

        if(dp[idx] != null)
            return dp[idx];

        String str = "";
        boolean val = false;
        for(int i = idx;i<s.length();i++){
            str = str + s.charAt(i);
            if(words.contains(str)){
                val =  breaks(s,words, i+1);
                if(val)
                    break;
            }
        }
        dp[idx] = val;
        return dp[idx];
    }
}
