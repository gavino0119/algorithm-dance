package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/4/13 18:04
 * @Description: 后续遍历 ---> 左 右 中
 */
public class PostorderTraversal {
    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    private void dfs(TreeNode root, List l){
        if(root==null){
            return;
        }
        // 左 右 中
        dfs(root.left,l);
        dfs(root.right,l);
        l.add(root.val);
    }
}
