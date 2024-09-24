package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreefromDescription2196 {

    public static void main(String[] args) {
        // [20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]
        int[][] descriptions = {
            {20, 15, 1},
            {20, 17, 0},
            {50, 20, 1},
            {50, 80, 0},
            {80, 19, 1}
        };
        TreeNode root = createBinaryTree(descriptions);
        TreeNode.printTree(root);
    }
    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] n : descriptions) {
            set.add(n[0]);
            if(!map.containsKey(n[0])){
                map.put(n[0], new TreeNode(n[0]));
            }
            if(!map.containsKey(n[1])){
                map.put(n[1], new TreeNode(n[1]));
            }
            if(n[2] == 0){
                map.get(n[0]).right = map.get(n[1]);
            }else{
                map.get(n[0]).left = map.get(n[1]);
            }
        }
        for (int[] n : descriptions) {
            set.remove(n[1]);
        }
        return map.get(set.iterator().next());
    }
}
