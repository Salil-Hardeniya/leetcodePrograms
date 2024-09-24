package problems;

public class NumArray {

    SegmentTree root = null;

    public static void main(String[] args) {
        int[] ar = {1, 3, 5};
        NumArray abc = new NumArray(ar);
        System.out.println(abc.sumTree(abc.root,0,2));
        System.out.println(abc.sumTree(abc.root,0,1));
        System.out.println(abc.sumTree(abc.root,1,2));
        abc.updateTree(abc.root,0,2);
        System.out.println(abc.sumTree(abc.root,0,2));
        System.out.println(abc.sumTree(abc.root,0,1));
        System.out.println(abc.sumTree(abc.root,1,2));
        abc.updateTree(abc.root,1,2);
        System.out.println(abc.sumTree(abc.root,0,2));
        System.out.println(abc.sumTree(abc.root,0,1));
        System.out.println(abc.sumTree(abc.root,1,2));

    }


    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length -1);
    }

    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumTree(root, left, right);
    }

    SegmentTree buildTree(int[] nums, int l, int r){
        if(l>r){
            return null;
        }
        SegmentTree temp = new SegmentTree(l,r);
        if(l == r){
            temp.sum = nums[l];
            return temp;
        }
        int mid = l + (r-l)/2;
        temp.left = buildTree(nums, l, mid);
        temp.right = buildTree(nums, mid+1, r);
        temp.sum = temp.left.sum + temp.right.sum;
        return temp;
    }

    void updateTree(SegmentTree root, int id, int val){
        if(root == null)
            return;

        if(root.l == root.r && root.l == id){
            root.sum = val;
            return;
        }
        int mid = root.l + (root.r - root.l) / 2;
        if(id <= mid )
            updateTree(root.left, id, val);
        else
            updateTree(root.right, id, val);
        root.sum = root.left.sum + root.right.sum;
    }

    int sumTree(SegmentTree root, int l, int r){
        int mid = root.l + (root.r - root.l) / 2;
        if(root.l == l && r == root.r)
            return root.sum;
        else if(r <= mid){
            return sumTree(root.left, l, r);
        }
        else if(l >= mid+1){
            return sumTree(root.right, l, r);
        }
        else{
            return  sumTree(root.left, l, mid) + sumTree(root.right, mid +1, r);
        }

    }


    static class SegmentTree{
        int l,r;
        SegmentTree left,right;
        int sum;

        SegmentTree(int l, int r){
            this.l = l;
            this.r = r;
            left = null;
            right = null;
            sum = 0;
        }
    }
}
