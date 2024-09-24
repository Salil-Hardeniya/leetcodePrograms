package problems;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Map<Tree, Integer> ar = new HashMap<>();
        ar.put(new Tree(1, "salil"), 1);
        ar.put(new Tree(1, "salil"), 2);

        System.out.println(ar.size());
        System.out.println(ar);

    }

    public static class Tree {
        int val;
        String abc;
        Tree(int x, String y) { val = x; abc = y; }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Tree t)) return false;
            return t.val == this.val && t.abc.equals(this.abc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, abc);
        }
    }
}
