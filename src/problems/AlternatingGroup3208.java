package problems;

import java.util.Arrays;

public class AlternatingGroup3208 {
    static int count = 0;
    public static void main(String[] args) {
        AlternatingGroup3208 alternatingGroup3208 = new AlternatingGroup3208();
        int ans = alternatingGroup3208.numberOfAlternatingGroups(new int[]{0,1,1},3);
        System.out.println(ans);
    }

    private int numberOfAlternatingGroups(int[] colors, int k) {
        int l = colors.length;
        int[] arr = new int[l + k -1];
        System.arraycopy(colors, 0, arr, 0, l);
        if (k - 1 >= 0) System.arraycopy(colors, 0, arr, l, k - 1);
        System.out.println(Arrays.toString(arr));

        count(arr, k, 0);
        return count;
    }

    void count(int[] colors, int k, int st){
        int i = st+1;
        int c = 0;
        while( i < colors.length && (colors[i] ^ colors[i-1]) != 0){
            c++;
            i++;
        }
        if(i > colors.length)
            return;
        ++c;
        count += k <= c ? c-k+1 : 0;

        while(i < colors.length && (colors[i] ^ colors[i-1]) == 0){
            i++;
        }
        if(i >= colors.length)
            return;
        count(colors, k, i-1);
    }
}
