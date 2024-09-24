package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBST {

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for(TreeNode t : res){
            System.out.println(t);
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

     static  List<TreeNode> generate(int s, int e){

        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for(int i = s;i<=e;i++){
            List<TreeNode> left = generate(s,i-1);
            List<TreeNode> right = generate(i+1,e);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
