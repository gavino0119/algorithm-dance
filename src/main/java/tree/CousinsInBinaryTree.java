package tree;

/**
 * @Author yanwg
 * @Date 2021/5/17 9:22
 * @Description: 二叉树的堂兄弟节点
 */
public class CousinsInBinaryTree {
    private int cntX;
    private int cntY;
    private int deptX;
    private int deptY;
    private TreeNode parentX;
    private TreeNode parentY;
    private boolean outX = false;
    private boolean outY = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        // dep(x) == dep(y) && parent(x) != parent(y)
        dfs(root,x,y);
        System.out.println(deptX);
        System.out.println(deptY);
        System.out.println(parentX.val);
        System.out.println(parentY.val);
        return (parentX!=parentY) && (deptX==deptY);
    }

    private void dfs(TreeNode root,int x, int y){
        if (root == null) {
          return;
        }
        if (outX && outY) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                parentX = root.left;
                deptX = cntX;
            }
            if (root.left.val == y) {
                parentY = root.left;
                deptY = cntX;
            }
        }
        if (root.right != null) {
            if (root.right.val == x) {
                parentX = root.right;
                deptX = cntX;
            }
            if (root.right.val == y) {
                parentY = root.right;
                deptY = cntX;
            }
        }

        cntX++;
        cntY++;
        dfs(root.left,x,y);
        dfs(root.right,x,y);
    }
}
