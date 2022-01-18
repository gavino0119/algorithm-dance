package nowcoder.lianbiao;

import nowcoder.ListNode;

/**
 * @Author yanwg
 * @Date 2022/1/18 15:19
 * @Description: 划分链表 （双指针）
 */
public class Nc_23_Partition {
    public ListNode partition(ListNode head, int x) {
        // write code here
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
