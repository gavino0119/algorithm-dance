package leetcode.easy;

/**
 * @Author yanwg
 * @Date 2021/6/5 11:29
 * @Description: 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class _203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode tmp = dummpy.next;
        ListNode pre = dummpy;
        while (tmp!=null){
            if (tmp.val==val) {
                pre.next = tmp.next;
            }else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return dummpy.next;
    }
}
