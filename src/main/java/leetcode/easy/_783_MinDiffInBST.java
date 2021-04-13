package leetcode.easy;


import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/4/13 9:29
 * @Description: 二叉搜索树节点最小距离
 */
public class _783_MinDiffInBST {
    /**
     * 中序递归获取递增数组
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        if (list.size()==1) {
            return 0;
        }
        for (int i = 1; i < list.size() ; i++) {
            min = Math.min(min,list.get(i) - list.get(i - 1));
        }
        return min;
    }

    /**
     * 栈模拟
     * 中序遍历的过程中用 prev 变量保存前驱节点，这样即能边遍历边更新答案，不再需要显式创建数组来保存，
     * @param root
     * @return
     */
    public int minDiffInBST1(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        TreeNode prev = null;
        // ------
        return ans;
    }
    private void dfs(TreeNode root, List list){
        if (root == null) {
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
