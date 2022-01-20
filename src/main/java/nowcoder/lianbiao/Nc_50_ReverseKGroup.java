package nowcoder.lianbiao;

import nowcoder.ListNode;

/**
 * @Author yanwg
 * @Date 2022/1/20 10:18
 * @Description: 链表中的节点每k个一组翻转
 */
public class Nc_50_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dum.next;
                }
            }
            ListNode q = tail.next;
            // 翻转
            ListNode[] node = reserver(head, tail);
            head = node[0];
            tail = node[1];
            // 拼接
            pre.next = head;
            tail.next = q;
            pre = tail;
            head = tail.next;
        }
        return dum.next;
    }

    private ListNode[] reserver(ListNode head, ListNode tail) {
        ListNode cru = head;
//        ListNode pre = tail;
        ListNode pre = tail.next;
//        while (cru != tail) {
        while (pre != tail) {
            ListNode next = cru.next;
            cru.next = pre;
            pre = cru;
            cru = next;
        }
        return new ListNode[]{tail, head};
    }
}
