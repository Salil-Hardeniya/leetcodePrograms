package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeDigitEven2094 {
    public static void main(String[] args) {
        ThreeDigitEven2094 m = new ThreeDigitEven2094();
        int[] digits = {2,1,3,0};
        int[] ans = m.findEvenNumbers(digits);
        System.out.println(Arrays.toString(ans));
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        int[] ans = new int[10];
        for(int n : digits)
            freq[n]++;

        List<Integer> ar = new ArrayList<>();
        for(int i = 100;i<999;i=i+2){
            Arrays.fill(ans, 0);
            int n = i;
            int x = n%10; n /=10;
            int y = n%10; n /=10;
            int z = n%10;
            ans[x]++;ans[y]++;ans[z]++;
            if(ans[x] > freq[x] || ans[y] > freq[y] || ans[z] > freq[z])
                continue;
            ar.add(i);
        }
        return ar.stream().mapToInt(i->i).toArray();
    }
}
