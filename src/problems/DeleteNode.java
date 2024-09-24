package problems;

public class DeleteNode {

    public static void main(String[] args) {
        Integer[] ar = {1,1,1};
        TreeNode root = TreeNode.createTree(ar);
        int target = 1;
        deleteNode(root, target);
        if(root.val == target && root.left == null && root.right == null)
            root = null;
        System.out.println(root);
    }

    public static boolean deleteNode(TreeNode root, int target){
        if(root == null)
            return false;
        boolean l = deleteNode(root.left, target);
        boolean r = deleteNode(root.right, target);

        if(l)
            root.left = null;
        if(r)
            root.right = null;

        if(root.val == target && root.left == null && root.right == null)
            return true;

        return  false;
    }
}
