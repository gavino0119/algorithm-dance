package acwing;

/**
 * @Author yanwg
 * @Date 2021/7/6 9:26
 * @Description:
 */
public class _1560 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dum.next;
                }
            }
            ListNode nex = tail.next;
            // 翻转区间
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return dum.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cru = head;
        while (prev != tail) {
            ListNode nex = cru.next;
            cru.next = prev;
            prev = cru;
            cru = nex;
        }
        return new ListNode[]{tail, head};
    }
}
