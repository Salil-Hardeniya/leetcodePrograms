package problems;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static TreeNode createTree(List<Integer> list) {
        if (list == null || list.isEmpty() || list.get(0) == null) return null;

        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < list.size()) {
            TreeNode current = queue.poll();

            if (i < list.size() && list.get(i) != null) {
                current.left = new TreeNode(list.get(i));
                queue.add(current.left);
            }
            i++;

            if (i < list.size() && list.get(i) != null) {
                current.right = new TreeNode(list.get(i));
                queue.add(current.right);
            }
            i++;
        }

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
