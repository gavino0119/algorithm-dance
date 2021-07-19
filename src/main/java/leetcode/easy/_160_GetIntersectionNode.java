package leetcode.easy;

/**
 * @Author yanwg
 * @Date 2021/6/4 9:28
 * @Description: 相交链表
 * 输入：
 * listA = [4,1,8,4,5]
 * listB = [5,0,1,8,4,5]
 * skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 */
public class _160_GetIntersectionNode {
    public ListNode getIntersectionNodeMy(ListNode headA, ListNode headB) {
        return null;
    }

    /**
     * 双指针（官解）
     * @param headA
     * @param headB
     * @return
     * 只有当两个链表都不为空时，才可能相交
     * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 4 1 8 4 5
        // 5 0 1 8 4 5
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;// 5 null 5    0 1
            pB = pB == null ? headA : pB.next;// 4 5    null 4 1
        }
        return pA;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "-->" + val +
                " " + next +
                ' ';
    }
}
