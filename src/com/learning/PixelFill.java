package com.learning;

import lombok.val;

import java.util.*;

public class PixelFill {
    public static void main(String[] args) {

        int[][] ar = {{0,0,0},{1,0,0}};
        int sc =1; int sr  = 0; int col = 5;
        System.out.println(Arrays.deepToString(ar));
        System.out.println("ln");
        System.out.println(Arrays.deepToString(PixelFill(ar,sc,sr,col)));
        System.out.println("ln");
        System.out.println(Arrays.deepToString(ar));
    }

    private static int[][] PixelFill(int[][] image, int sc,  int sr,  int color) {
        if (image[sr][sc] == color) return image;
        int r = image.length;
        int c = image[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Pair> q= new ArrayDeque<>();
        int col = image[sc][sr];

        Pair ab = new Pair(sc,sr);
        q.offer(ab);
        image[ab.x][ab.y] = color;


        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i =0;i<4;i++){
                int x = p.x + dir[i][0];
                int y = p.y + dir[i][1];
                if(x < 0 || y< 0 || x>=r || y>=c || image[x][y] != col) continue;
                Pair av = new Pair(x,y);
                image[x][y] = color;
                q.offer(av);
            }
        }

        return  image;

    }

    public static class Pair {
        int x; int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
