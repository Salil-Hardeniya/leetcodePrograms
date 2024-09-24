package problems;

import java.util.Arrays;

public class CountBits { //338
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] a= new int[n+1];
        a[0] = 0;
        int mul = 1;
        for(int i = 1; i<=n;i++){
            if(i == 2*mul){
                mul = 2*mul;
            }
            a[i] = 1 + a[i - mul];
        }
        return a;
    }
}
