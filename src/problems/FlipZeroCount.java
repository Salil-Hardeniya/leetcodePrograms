package problems;

public class FlipZeroCount {
    public static void main(String[] args) {
        int[] ar = {1,1,1,1,1,1};
        int res = 0; int k = 1;
        int l = 0; int r = 0;
        int count = 0;
        while(r < ar.length){
            if(ar[r] == 0)
                count++;
            while(count > k){
                if(ar[l] == 0)
                    count--;
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        System.out.println(res);

    }
}
