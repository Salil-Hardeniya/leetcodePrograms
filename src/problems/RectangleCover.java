package problems;

import java.util.*;

public class RectangleCover {

    public static void main(String[] args) {
//        int[][] rec = {{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};
//        System.out.println(isRectangleCover(rec));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        HashMap<Point, Integer> map = new HashMap<>();
        long sumArea = 0;
        for (int[] rectangle : rectangles) {
            sumArea += (long) (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            Point p1 = new Point(rectangle[0], rectangle[1]);
            map.computeIfPresent(p1, (k, v) -> v + 1);
            map.putIfAbsent(p1, 1);
            p1 = new Point(rectangle[2], rectangle[3]);
            map.computeIfPresent(p1, (k, v) -> v + 1);
            map.putIfAbsent(p1, 1);
            p1 = new Point(rectangle[0], rectangle[3]);
            map.computeIfPresent(p1, (k, v) -> v + 1);
            map.putIfAbsent(p1, 1);
            p1 = new Point(rectangle[2], rectangle[1]);
            map.computeIfPresent(p1, (k, v) -> v + 1);
            map.putIfAbsent(p1, 1);
        }
        int cend = 0;
        List<Point> ar = new ArrayList<>();
        for(Map.Entry<Point, Integer> e : map.entrySet()){
            if(e.getValue() == 1){
                ar.add(e.getKey());
                cend++;
            }
            else if(e.getValue() % 2 == 1)
                return false;
        }

        if(cend != 4)
            return false;
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        for(Point p : ar){
            if(p.x < minx)
                minx = p.x;
            else if(p.x > maxx)
                maxx = p.x;
            if(p.y < miny)
                miny = p.y;
            else if(p.y > maxy)
                maxy = p.y;
        }
        return sumArea == (long) (maxx - minx) * (maxy - miny);

    }

    public static class Point{
        int x;
        int y;
        Point(int a, int b){
            x = a;
            y = b;
        }

        @Override
        public int hashCode(){
            int hash = 17;
            hash = hash *31 + x;
            hash = hash *31 + y;
            return hash;
        }


        public boolean equals(Object p){
            if(!(p instanceof Point ob))
                return false;
            return ob.x == this.x && ob.y == this.y;
        }

    }
}
