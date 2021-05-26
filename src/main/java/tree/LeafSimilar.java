package tree;

import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/5/10 9:43
 * @Description: 叶子相似的树
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals(dfs(root2));
    }

    private String dfs(TreeNode root){
        StringBuilder str = new StringBuilder("");
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left == null && pop.right==null) {
                str.append(pop.val).append(",");
            }
            if (pop.right!=null) {
                stack.addFirst(pop.right);
            }
            if (pop.left!=null) {
                stack.addFirst(pop.left);
            }
        }
        return str.toString();
    }
}
