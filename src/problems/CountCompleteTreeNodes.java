package problems;

import java.util.Arrays;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Integer[] ar = {1,2,3,4,5,6};
        TreeNode root = TreeNode.createTree(Arrays.asList(ar));
        long start = System.nanoTime();
        int result = countNodes(root);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.printf("time took %d",(end - start));

    }

    static int res = 0;

    public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if(leftH == rightH){
            res += Math.pow(2,leftH) ;
            countNodes(root.right);
        }
        else{
            res += Math.pow(2,rightH);
            countNodes(root.left);
        }


        return res;
    }

    static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int h = 1;
        while(root.left != null){
            h++;
            root = root.left;
        }
        return h;
    }
}
