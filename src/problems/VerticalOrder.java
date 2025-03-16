package problems;

import java.util.*;

public class VerticalOrder {

    public static void main(String[] args) {
        Integer[] ar = new Integer[7];
//        int i = 0;
//        ar[0] = 3;
//        ar[1] = 9;
//        ar[2] = 20;
//        ar[3] = null;
//        ar[4] = null;
//        ar[5] = 15;
//        ar[6] = 7;
        int i = 0;
        for (Integer a: List.of(1,2,3,4,6,5,7)) {
            ar[i++] = a;
        }
        System.out.println(verticalTraversal(TreeNode.createTree(Arrays.asList(ar))));
    }
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int min = 0; static int max = 0;
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        Comparator<Node> comp = (a,b) -> {
            if(a.r < b.r){
                return -1;
            }
            else if(a.r > b.r){
                return 1;
            }
            else{
                if(a.v < b.v){
                    return -1;
                }
                else if(a.v > b.v)
                    return 1;
            }
            return 0;
        };
        List<Node> a;
        for(int i = min;i<=max;i++){
            a = map.get(i);
            a.sort(comp);
            List<Integer> ar = new ArrayList<>();
            for(Node n : a){
                ar.add(n.v);
            }
            res.add(ar);
        }
        return res;
    }

    public static void traverse(TreeNode root, int c, int r){
        if(root == null) return;
        map.computeIfAbsent(c, k -> new ArrayList<>());
        map.get(c).add(new Node(r,root.val));
        if(c < min) min = c;
        if(c > max) max = c;
        traverse(root.left,c-1, r+1);
        traverse(root.right,c+1, r+1);
    }

    public static class Node{
        int r;
        int v;
        Node(int r, int v){
            this.r = r;
            this.v = v;
        }

        @Override
        public String toString(){
            return String.format("row: %d Value: %d",r,v);
        }
    }
}
