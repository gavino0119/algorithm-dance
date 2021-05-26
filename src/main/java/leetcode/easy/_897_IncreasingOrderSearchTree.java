package leetcode.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/4/25 10:05
 * @Description: 递增顺序搜索树
 */
public class _897_IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        TreeNode res = new TreeNode(-1);
        TreeNode cur = res;
        for(int l : list){
            cur.right = new TreeNode(l);
            cur = cur.right;
        }
        return res.right;
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

}
