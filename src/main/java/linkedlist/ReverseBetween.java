package linkedlist;

/**
 * @Author yanwg
 * @Date 2021/6/1 9:18
 * @Description: 翻转某个区间的链表
 * 给你一个链表和两个数m  , n    要求对下标m-n之间的节点进行翻转
 */
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        ListNode se = head.next;
        ListNode tr = new ListNode(8);
        se.next = tr;
        tr.next = new ListNode(9);

        // 原链表
        System.out.println(head);

        // 翻转某段链表
        reverseBetween(head,2,3);
        System.out.println(head);

    }
}
