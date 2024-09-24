package problems;

import java.util.*;
import java.util.stream.Collectors;

public class RobotCollision2751 {
    public static void main(String[] args) {
        int[] positions = {5,4,3,2,1};
        int[] healths = {2,17,9,15,10};
        String directions = "RRRRR";
        System.out.println(new RobotCollision2751().survivedRobotsHealths(positions, healths, directions));
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        Comparator<Robot> comp = Comparator.comparingInt(a -> a.pos);
        robots.sort(comp);
        Stack<Robot> st = new Stack<>();
        for (Robot r : robots) {
            if (st.isEmpty()) {
                st.push(r);
            }
            else{
                Robot lst = st.peek();
                if (!('R' == lst.dir && 'L' == r.dir)) {
                    st.push(r);
                } else {
                    boolean add = false;
                    while ('R' == lst.dir && 'L' == r.dir) {
                        if (lst.heal == r.heal) {
                            st.pop();
                            add = false;
                            break;
                        } else if (lst.heal > r.heal) {
                            --lst.heal;
                            add = false;
                            break;
                        } else {
                            add = true;
                            --r.heal;
                            st.pop();
                        }
                        if (st.isEmpty())
                            break;
                        lst = st.peek();
                    }
                    if (add)
                        st.push(r);
                }
            }
        }
        robots.clear();
        while (!st.isEmpty())
            robots.add(st.pop());
        comp = Comparator.comparingInt(a -> a.id);
        robots.sort(comp);
        return robots.stream().map(ro -> ro.heal).collect(Collectors.toList());
    }

    public static class Robot {
        Integer id;
        int pos;
        int heal;
        char dir;

        Robot(Integer i, int a, int b, char c) {
            id = i;
            pos = a;
            heal = b;
            dir = c;
        }
    }
}
