package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/4/13 10:14
 * @Description: 中序遍历(左中右)
 */
public class InorderTraversal {

    /**
     * 递归
     * 递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中，
     * 然后递归返回的时候，从栈顶弹出上一次递归的各项参数，
     * 所以这就是递归为什么可以返回上一层位置的原因
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    /**
     * 递推(非递归)
     * 用栈也可以实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        return null;
    }
}

