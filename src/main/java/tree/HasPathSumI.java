package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/7/26 9:17
 * @Description:
 */
public class HasPathSumI {
    /**
     * bfs
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        return false;
    }
}
