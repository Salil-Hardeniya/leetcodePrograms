package problems;

import lombok.Data;

@Data
public class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


      public static TreeNode createTree(Integer[] list){
          return createTreeHelper(list, 0);
      }

    private static TreeNode createTreeHelper(Integer[] list, int index) {
        if (index >= list.length || list[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(list[index]);
        root.left = createTreeHelper(list, 2 * index + 1); // Calculate left child index
        root.right = createTreeHelper(list, 2 * index + 2); // Calculate right child index

        return root;
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
