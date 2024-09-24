package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] dif = {49,49,76,88,100};
        int[] pro = {5,8,75,89,94};
        int[] worker = {98,72,16,27,76};
        System.out.println(maxProfitAssignment(dif, pro, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] res = new int[difficulty.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[] { difficulty[i], profit[i] };
        }
        Comparator<int[]> comp = (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        };
        Arrays.sort(res, comp);
        List<int[]> list = Arrays.asList(res);
        int[][] temp = new int[res.length][2];
        int j = 1;
        temp[0] = res[0];
        for(int i = 1;i<difficulty.length;i++){
            if (res[i][0] == res[i-1][0])
                continue;
            temp[j++] = res[i];
        }
        res = temp;
        int[] pro = new int[100001];
        int profi = 0;
        for(int i = 0;i<j;i++){
            pro[res[i][0]] = -1;
        }
        int id = 0;
        for(int i = 0;i<100001;i++){
            if(pro[i] == -1){
                profi = Math.max(profi,res[id++][1]);
            }
            pro[i] = profi;
        }
        int ans = 0;
        for (int k : worker) {
            ans += pro[k];
        }
        return ans;
    }
}
