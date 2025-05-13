package problems;

import java.util.Arrays;

public class EqualSumGridPartitionW449 {
    public static void main(String[] args) {
        EqualSumGridPartitionW449 e = new EqualSumGridPartitionW449();
        int[][] grid = {{1,3},{2,4}};
        System.out.println(e.canPartitionGrid(grid));
    }

    public boolean canPartitionGrid(int[][] grid) {
        long[] row = new long[grid.length];
        long[] col = new long[grid[0].length];
        int x =0;
        for(int[] ar : grid){
            row[x++] = Arrays.stream(ar).sum();
        }
        for(int i = 0;i<grid[0].length;i++){
            for(int j = 0;j<grid.length;j++){
                col[i] += grid[j][i];
            }
        }
        long rowSum = Arrays.stream(row).sum();
        if(rowSum % 2 ==0){
            long temp = 0;
            for(long t : row){
                temp +=t;
                if(temp == rowSum/2)
                    return true;
            }
        }
        long colSUm = Arrays.stream(col).sum();
        if(colSUm % 2 ==0){
            long temp = 0;
            for(long t : col){
                temp +=t;
                if(temp == colSUm/2)
                    return true;
            }
        }
        return false;
    }
}
