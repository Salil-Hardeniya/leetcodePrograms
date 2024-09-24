package problems;

public class MinimumPenalty {
    public static void main(String[] args) {

        System.out.println(bestClosingTime("YYNY"));

    }
    public static int bestClosingTime(String customers) {
        int l = customers.length();
        int[] Ncount = new int[l+1];
        int[] Ycount = new int[l];
        int c0 = 0, c1=0;
        for(int i = 0;i<l;i++){
            char ch = customers.charAt(i);
            if(ch == 'N'){
                c0++;
            }
            Ncount[i+1] = c0;
            ch = customers.charAt(l-i-1);
            if(ch == 'Y'){
                c1++;
            }
            Ycount[l-i-1] = c1;
        }
        Ncount[0] = 0;
        int res = 0;
        int mi = Integer.MAX_VALUE;
        for(int i = 0;i < l;i++){
            int temp = Ncount[i] + Ycount[i];
            if(temp < mi){
                res = i;
                mi = temp;
            }
        }

        if(mi > Ncount[l])
            return l;
        return res;

    }
}
