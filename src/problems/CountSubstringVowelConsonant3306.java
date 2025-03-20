package problems;

import java.util.Arrays;

public class CountSubstringVowelConsonant3306 {
    public static void main(String[] args) {
        CountSubstringVowelConsonant3306 countSubstringVowelConsonant3306 = new CountSubstringVowelConsonant3306();
        long ans = countSubstringVowelConsonant3306.countOfSubstrings("ieaouqqieaouqq",1);
        System.out.println(ans);
    }

    public long countOfSubstrings(String word, int k) {
        return atleastK(word, k) - atleastK(word, k+1);
    }

    public long atleastK(String word, int k) {
        long numValidSubstrings = 0;
        int[] countV = new int[26];
        Arrays.fill(countV,1);
        countV[0] = 0;countV[4] = 0;countV[8] = 0;countV[14] = 0;countV[20] = 0;
        char[] ch = word.toCharArray();
        int left = 0;
        int count =0;
        for(int right =0; right<ch.length; right++){
            char cr = ch[right];
            if(isVowel(cr))
                countV[cr-'a'] += 1;
            else
                count++;

            while(isValid(countV) && count >= k){
                numValidSubstrings += word.length() - right;
                char c = ch[left];
                if(isVowel(c))
                    countV[c-'a'] -= 1;
                else
                    count--;
                left++;
            }
        }

        return numValidSubstrings;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private boolean isValid(int[] countV){
        for(int i : countV){
            if(i<1)
                return false;
        }
        return true;
    }
}
