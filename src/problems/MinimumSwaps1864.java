package problems;

public class MinimumSwaps1864 {
    public static void main(String[] args) {
        System.out.println(minSwaps("111000"));
    }

    public static int minSwaps(String s) {
        int c0 = 0; int c1 =0;
        for(int i = 0;i<s.length();i++){
            if('0' == s.charAt(i))
                ++c0;
            else
                ++c1;
        }
        if( Math.abs(c1-c0) > 1)
            return -1;
        if(c1 > c0)
            return compare(s, '1');
        if(c1 < c0)
            return compare(s, '0');
        return Math.min(compare(s, '0'),compare(s, '1'));
    }

    static int compare(String s, char a){
        int c = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != a)
                c++;
            if(a == '0')
                a = '1';
            else
                a = '0';
        }
        return c/2;
    }
}
