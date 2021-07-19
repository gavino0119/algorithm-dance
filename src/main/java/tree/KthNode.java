package tree;

/**
 * @Author yanwg
 * @Date 2021/7/13 9:30
 * @Description:
 */
public class KthNode {
    TreeNode ans = null;
    public TreeNode kthNode(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }
    private void dfs(TreeNode root,int k){
        if (root.left != null) {
            dfs(root.left,k);
        }
        k--;
        if (k < 0) {
            ans = root;
        }
        if (root.right != null) {
            dfs(root.right,k);
        }
    }
}
