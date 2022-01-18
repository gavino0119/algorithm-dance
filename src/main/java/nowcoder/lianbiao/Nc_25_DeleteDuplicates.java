package nowcoder.lianbiao;

import nowcoder.ListNode;

/**
 * @Author yanwg
 * @Date 2022/1/18 15:57
 * @Description: 删除有序链表中重复的元素-I
 */
public class Nc_25_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode cru = head;
        while (cru != null) {
            // 注意这里 不是if
            while (cru.next != null && cru.val == cru.next.val) {
                cru.next = cru.next.next;
            }
            cru = cru.next;
        }
        return head;
    }
}
