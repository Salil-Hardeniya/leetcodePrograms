package problems;

import java.util.*;

public class MaximumProductSplitTree1339 {
    public static void main(String[] args) {
        MaximumProductSplitTree1339 maximumProductSplitTree1339 = new MaximumProductSplitTree1339();
        List<Integer> ar = new ArrayList<>();
        ar.add(1);ar.add(null);ar.add(2);ar.add(3);ar.add(4);ar.add(null);ar.add(null);ar.add(5);ar.add(6);
//        ar.add(1); ar.add(1);
        TreeNode treeNode = TreeNode.createTree(ar);
//        int ans = maximumProductSplitTree1339.maxProduct(treeNode);
//        System.out.println(ans);

        String[] strs = {"act","pots","tops","cat","stop","hat"};
        Map<char[], List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.putIfAbsent(chars, new ArrayList<>());
            map.get(chars).add(str);
        }

    }

    List<Integer> values = new ArrayList<>();
    int MOD = 1_000_000_007;
//    public int maxProduct(TreeNode root) {
//        if(root == null)
//            return 0;
//        int total = populateValues(root);
//        long best = Long.MIN_VALUE;
//
//        for (int x : values) {
//            long product = (long) x * (total - x);
//            if (product > best) {
//                best = product;
//            }
//        }
//
//        return (int) (best % MOD);
//    }
//
//    private int populateValues(TreeNode root) {
//        if(root == null)
//            return 0;
//        int currentTotal = populateValues(root.left) + populateValues(root.right) + root.val;
//        values.add(currentTotal);
//        return currentTotal;
//    }

    int total;
    long ans = Long.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        if(root == null)
            return 0;
        total = populateValues(root);
        maximizeProduct(root);

        return (int) (ans % MOD);
    }

    private int populateValues(TreeNode root) {
        if(root == null)
            return 0;
        root.val = populateValues(root.left) + populateValues(root.right) + root.val;
        return root.val;
    }

    private void maximizeProduct(TreeNode root) {
        if(root == null) return;

        if(root.left != null){
            ans = Math.max(ans, (long) (total - root.left.val) * root.left.val);
        }

        if(root.right != null){
            ans = Math.max(ans, (long) (total - root.right.val) * root.right.val);
        }

        maximizeProduct(root.right);
        maximizeProduct(root.left);

    }
}
