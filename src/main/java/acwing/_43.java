package acwing;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/6/24 13:17
 * @Description:
 */
public class _43 {
    public List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.addLast(root);
        while(!que.isEmpty()){
            TreeNode node = que.pollFirst();
            res.add(node.val);
            if(node.left!=null){
                que.addLast(node.left);
            }
            if(node.right!=null){
                que.addLast(node.right);
            }
        }
        return res;
    }
}
