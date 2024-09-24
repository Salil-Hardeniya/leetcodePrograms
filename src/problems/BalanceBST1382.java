package problems;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST1382 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        BalanceBST1382 balanceBST1382 = new BalanceBST1382();
        System.out.println(root);
        TreeNode result = balanceBST1382.balanceBST(root);
        System.out.println(result);
    }

    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return root;
        toList(root);
        return toTree(0, list.size()-1);
    }

    void toList(TreeNode root){
        if(root == null)
            return;
        toList(root.left);
        list.add(root.val);
        toList(root.right);
    }

    TreeNode toTree(int s, int e){
        if(s>e)
            return null;
        int mid = s+(e-s)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = toTree(s,mid-1);
        root.right = toTree(mid+1,e);
        return root;
    }

}
