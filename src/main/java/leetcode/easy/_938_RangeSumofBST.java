package leetcode.easy;

import tree.TreeNode;

/**
 * @Author yanwg
 * @Date 2021/4/27 10:01
 * @Description:
 */
public class _938_RangeSumofBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        dfs(root.left,low,high);
        if(root.val>=low && root.val<=high){
            sum+=root.val;
        }
        dfs(root.right,low,high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        _938_RangeSumofBST k = new _938_RangeSumofBST();
        System.out.println(k.rangeSumBST(root, 7, 15));
    }
}
