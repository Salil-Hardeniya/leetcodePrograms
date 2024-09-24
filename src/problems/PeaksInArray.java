package problems;

import java.util.ArrayList;
import java.util.List;

public class PeaksInArray {
    public static void main(String[] args) {
        System.out.println(countOfPeaks(new int[]{5,5,10,7,7,10,5}, new int[][]{{1,1,6}, {2,2,3}, {1,6,6}, {2,2,1}}));
    }
    
    public static List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int l = nums.length;
        int[] peak = new int[l];
        for (int i = 1; i < l - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                peak[i] = 1;
        }
        SegmentTree root = buildTree(peak, 0, l - 1);
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1){
                int a = sumTree(root,q[1],q[2]);
                if(peak[q[1]] == 1)
                    --a;
                if(peak[q[2]] == 1)
                    --a;
                res.add(a>0?1:a);
            }
            else {
                int id = q[1];
                int val = q[2];
                nums[id] = val;
                if (id > 0 && id < l - 1) {
                    if (nums[id] > nums[id - 1] && nums[id] > nums[id + 1]) {
                        updateTree(root, id, 1);
                        peak[id] = 1;
                    } else {
                        updateTree(root, id, 0);
                        peak[id] = 0;
                    }
                }
                if (id - 1 > 0 && id-1 < l - 1) {
                    if (nums[id - 1] > nums[id - 2] && nums[id - 1] > nums[id]) {
                        updateTree(root, id - 1, 1);
                        peak[id - 1] = 1;
                    } else {
                        updateTree(root, id - 1, 0);
                        peak[id - 1] = 0;
                    }
                }
                if (id >= 0 && id + 1 < l - 1) {
                    if (nums[id + 1] > nums[id] && nums[id + 1] > nums[id + 2]) {
                        updateTree(root, id + 1, 1);
                        peak[id + 1] = 1;
                    } else {
                        updateTree(root, id + 1, 0);
                        peak[id + 1] = 0;
                    }
                }
            }
        }
        return res;

    }

    static SegmentTree buildTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        SegmentTree root = new SegmentTree(l, r);
        if (l == r) {
            root.sum = nums[l];
            return root;
        }
        int mid = l + (r - l) / 2;
        root.left = buildTree(nums, l, mid);
        root.right = buildTree(nums, mid + 1, r);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    static void updateTree(SegmentTree root, int id, int val) {
        if (root == null)
            return;

        int mid = root.l + (root.r - root.l) / 2;
        if (root.l == root.r && root.l == id) {
            root.sum = val;
            return;
        }
        if (id <= mid)
            updateTree(root.left, id, val);
        else
            updateTree(root.right, id, val);
        root.sum = root.left.sum + root.right.sum;
    }

    static int sumTree(SegmentTree root, int l, int r) {
        if (root.l == l && r == root.r)
            return root.sum;
        int mid = root.l + (root.r - root.l) / 2;
        if (r <= mid)
            return sumTree(root.left, l, r);
        if (l > mid)
            return sumTree(root.right, l, r);
        return sumTree(root.left, l, mid) + sumTree(root.right, mid + 1, r);
    }

    static class SegmentTree {
        int l, r;
        SegmentTree left, right;
        int sum;

        SegmentTree(int l, int r) {
            this.l = l;
            this.r = r;
            left = null;
            right = null;
            sum = 0;
        }
    }
}
