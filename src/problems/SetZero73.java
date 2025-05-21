package problems;

import java.util.Arrays;

public class SetZero73 {
    public static void main(String[] args) {

        int[][] array = ArrayParser.parse2DArray("[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]");
        System.out.println(Arrays.deepToString(array));
        setZeroes(array);
        System.out.println(Arrays.deepToString(array));
    }

    public static void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] a = new boolean[c];
        for(int i = 0;i<r;i++){
            boolean iszero = false;
            for(int j = 0;j<c;j++){
                if(matrix[i][j] == 0){
                    iszero = true;
                    a[j] = true;
                }
            }
            if(iszero)
                Arrays.fill(matrix[i], 0);
        }
        for(int i = 0;i<c;i++){
            if(a[i]){
                for(int j = 0;j<r;j++){
                    matrix[j][i] =0;
                }
            }
        }
    }
}
