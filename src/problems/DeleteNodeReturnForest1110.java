package problems;

import java.util.*;

public class DeleteNodeReturnForest1110 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.createTree(Arrays.asList(arr));
        int[] to_delete = {3,5};
        DeleteNodeReturnForest1110 deleteNodeReturnForest1110 = new DeleteNodeReturnForest1110();
        List<TreeNode> res = deleteNodeReturnForest1110.delNodes(root, to_delete);
        for(TreeNode node: res){
            TreeNode.printTree(node);
            System.out.println();
        }
    }
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int n: to_delete)
            set.add(n);
        boolean l = deleteNode(root);
        if(!l)
            res.add(root);
        return res;
    }

    public boolean deleteNode(TreeNode root){
        if(root == null)
            return false;
        boolean l = deleteNode(root.left);
        if(l)
            root.left = null;
        l =deleteNode(root.right);
        if(l)
            root.right = null;
        if(set.contains(root.val)){
            if(root.left != null)
                res.add(root.left);
            if(root.right != null)
                res.add(root.right);
            return true;
        }
        return false;
    }
}
