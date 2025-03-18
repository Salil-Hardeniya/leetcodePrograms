package problems;
/*
The thief has found himself a new place for his thievery again.
There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house.
After a tour, the smart thief realized that all houses in this place form a binary tree.
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree,
r
eturn the maximum amount of money the thief can rob without alerting the police.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII337 {
    public static void main(String[] args) {
        HouseRobberIII337 houseRobberIII337 = new HouseRobberIII337();
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(3);ar.add(4);ar.add(5);ar.add(1);ar.add(3);ar.add(null);ar.add(1);
        TreeNode root = TreeNode.createTree(ar);
        TreeNode.printTree(root);
        int ans = houseRobberIII337.rob(root);
        System.out.println();
        System.out.print(ans);
    }
    Map<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return robs(root);
    }

    public int robs(TreeNode root){
        if(root == null)
            return 0;
        if(dp.containsKey(root))
            return dp.get(root);
        int left = 0,right = 0;
        if(root.left != null)
            left = robs(root.left.left) + robs(root.left.right);
        if(root.right != null)
            right = robs(root.right.left) + robs(root.right.right);
        dp.put(root, Math.max(robs(root.left) + robs(root.right), root.val + left + right));
        return dp.get(root);
    }

//    public int rob(TreeNode root) {
//        int[] ans = helper(root);
//        return Math.max(ans[0],ans[1]);
//    }
//
//    public int[] helper (TreeNode node){
//        if(node == null){
//            return new int[]{0,0};
//        }
//
//        int[] left = helper(node.left);
//        int[] right = helper(node.right);
//
//        int rob = node.val + left[1] + right[1];
//        int not_rob = Math.max(left[0], left[1])+Math.max(right[0],right[1]);
//
//        return new int[]{rob, not_rob};
//    }
}
