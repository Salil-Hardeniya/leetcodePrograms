package problems;

import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MaxDistanceFromLand {
    public static void main(String[] args) throws ParseException {
//        int[][] ar = {{1,0,1},{0,0,0},{1,0,1}};
//        System.out.println(maxDistance(ar));

        SimpleDateFormat tempDate = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
    }

    public static long maxDistance(int[][] grid){
        int[] dir = {0,1,0,-1,0};
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == 1){
                    count++;
                    q.offer(new Pair(i,j,0));
                }
            }
        }

        if(count == 0 || count == row*col)
            return -1;
        int max = 0;
        while(!q.isEmpty()){
            int s = q.size();

            for(int i = 0;i<s;i++){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                int d = p.d;
                for(int j = 0;j<4;j++){
                    int nx = x + dir[j];
                    int ny = y + dir[j+1];
                    if(nx < 0 || nx == row || ny < 0 || ny == col || grid[nx][ny] == 1)
                        continue;
                    grid[nx][ny] = 1;
                    max = Math.max(max, d+1);
                    q.offer(new Pair(nx, ny, d+1));
                }
            }
        }


        return max;
    }

    @ToString

    public static class Pair{
        int x; int y; int d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

    }
}
