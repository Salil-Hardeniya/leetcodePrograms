package problems;

import java.util.*;

public class EquivalentDominoe1128 {
    public static void main(String[] args) {
        EquivalentDominoe1128 equivalentDominoe1128 = new EquivalentDominoe1128();
        int[][] array = {
                {1, 2},
                {1, 2},
                {1, 1},
                {1, 2},
                {2, 2}
        };
        int ans = equivalentDominoe1128.numEquivDominoPairs(array);
        System.out.println(ans);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        List<Pair> list = Arrays.stream(dominoes).map((a) -> new Pair(a[0], a[1])).toList();
        Map<Pair, Integer> map = new HashMap<>();
        for(Pair p : list){
            map.putIfAbsent(p, 0);
            map.computeIfPresent(p, (k,v) -> v+1);
        }
        int ans = 0;
        for(Integer entry : map.values()){
            ans += (entry * (entry - 1))/2;
        }
        return ans;
    }

    public static class Pair {
        int l;
        int r;
        public Pair(int l, int r){
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(!(obj instanceof Pair p))
                return false;
            return  (this.l == p.l && this.r == p.r) || (this.l == p.r && this.r == p.l);
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r) + Objects.hash(r, l);
        }
    }
}
