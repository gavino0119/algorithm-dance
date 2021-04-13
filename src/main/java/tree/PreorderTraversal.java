package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/4/13 17:56
 * @Description: 前序遍历  -------- 中 左 右
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root,List l){
        if(root==null){
            return;
        }
        // 中 左 右
        l.add(root.val);
        dfs(root.left,l);
        dfs(root.right,l);
    }
}
