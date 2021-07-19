package acwing;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yanwg
 * @Date 2021/6/25 13:00
 * @Description:
 *  将儿子加入新队列
 */
public class _44 {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //初始化一个装元素的集合
        List<Integer> level = new ArrayList<Integer>();
        que.add(root);
        //采用加入null，来标志本层元素已经遍历完
        que.add(null);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node==null){
                //并且如果level集合大小为0，说明整个树已经遍历完了，直接退出循环即可
                if(level.size()==0){
                    break;
                }
                List<Integer> tmp = new ArrayList<>(level);
                res.add(tmp);
                //并添加一个null标志
                que.add(null);
                //清除集合所有元素，为了下一层元素进入
                level.clear();
                //直接进入下一次循环，因为当前元素是null
                continue;
            }
            //添加当前元素值进入集合
            level.add(node.val);
            if (node.left != null) {
                que.add(node.left);
            }
            if (node.right != null) {
                que.add(node.right);
            }
        }
        return res;

    }
}
