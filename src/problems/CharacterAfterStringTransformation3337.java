package problems;

import java.util.List;

public class CharacterAfterStringTransformation3337 {
    public static void main(String[] args) {
        CharacterAfterStringTransformation3337 m = new CharacterAfterStringTransformation3337();
        int ans = m.lengthAfterTransformations("azbk", 2, List.of(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2));
        System.out.println(ans);

    }
    int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] count = new long[26][26];
        long ans = 0;
        for(char ch : s.toCharArray()){
            count[0][ch - 'a']++;
        }
        long[][] matrix = new long[26][26];
        for(int i = 0;i<26;i++){
            for(int j = 0;j<nums.get(i);j++){
                matrix[i][(i + j + 1) % 26]++;
            }
        }
        long[][] powerMat = getPowerMatrix(matrix, t);
        count = multiplyMatrix(count, powerMat);
        for (int i = 0; i < 26; i++) {
            ans = (ans + count[0][i]) % MOD;
        }
        return (int) ans;
    }

    private long[][] getPowerMatrix(long[][] matrix, int t) {
        long[][] res = new long[26][26];
        for(int i = 0;i<26;i++){
            res[i][i] = 1;
        }
        while(t>0){
            if((t & 1) == 1)
                res = multiplyMatrix(res, matrix);
            matrix = multiplyMatrix(matrix, matrix);
            t = t/2;
        }
        return res;
    }

    private long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[26][26];
        for(int i = 0;i<26;i++){
            for(int j = 0;j<26;j++){
                for(int k =0;k<26;k++){
                    res[i][j] = (res[i][j] + (matrix1[i][k] * matrix2[k][j]) % MOD) % MOD;
                }
            }
        }
        return res;
    }

//    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
//        int MOD = 1_000_000_007;
//        long[] count = new long[26];
//        for(char ch : s.toCharArray()){
//            count[ch - 'a']++;
//        }
//        long[] count1;
//        for(int i = 0;i<t;i++){
//            count1 = new long[26];
//            for(int j = 0;j<26;j++){
//                int nxt = nums.get(j);
//                for(int k = 0;k<nxt;k++){
//                    int x = (j+k+1)%26;
//                    count1[x] = (count1[x] +  count[j]) % MOD;
//                }
//            }
//            count = count1;
//        }
//        long ans = 0;
//        for (int i = 0; i < 26; i++) {
//            ans = (ans + count[i]) % MOD;
//        }
//
//        return (int) ans;
//    }
}
