package tree;

import java.util.*;

/**
 * @Author yanwg
 * @Date 2021/7/14 9:18
 * @Description:
 */
public class LevelOrder {
    /**
     * yxc version
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node==null){
                //
                if (level.size()==0) {
                    break;
                }
                List<Integer> tmp = new ArrayList<>(level);
                ans.add(tmp);
                //
                queue.addLast(null);
                level.clear();
                //
                continue;
            }
            level.add(node.val);
            if (node.left!= null) {
                queue.addLast(node.left);
            }
            if (node.right!= null) {
                queue.addLast(node.right);
            }
        }
        return ans;
    }
    public List<List<Integer>> levelOrderLeetCode(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
