package problems;

public class RandomCodes {
    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 10));
    }

    public static int uniquePaths(int m, int n) {
        int x = Math.max(m,n)-1;
        int z= Math.min(m,n)-1;
        int y = m+n-2;
        long res = 1;
        for(int i = y; i > x ;i--){
            res *= i;
        }
        for(int i = 1; i <= z ;i++){
            res /= i;
        }
        return (int )res;


    }
}
