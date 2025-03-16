package problems;

import java.util.Arrays;

public class DistributeCoin {

    static int res = 0;
    public static void main(String[] args) {
        Integer[] ar= {3,0,0};
        TreeNode root = TreeNode.createTree(Arrays.asList(ar));
        distributeCoins(root);
        System.out.println(res);
    }

    public static void distributeCoins(TreeNode root) {
        if(root == null)
            return;

        int x = 0;
        int y = 0;

        if(root.left != null){
            distributeCoins(root.left);
            x = 1-root.left.val;
            root.left.val = 1;
        }
        if(root.right != null) {
            distributeCoins(root.right);
            y = 1-root.right.val;
            root.right.val = 1;
        }


        res += Math.abs(x) + Math.abs(y);

        root.val = root.val - x - y;
    }
}
