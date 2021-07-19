package acwing;

/**
 * @Author yanwg
 * @Date 2021/7/5 9:41
 * @Description:
 */
public class _36 {
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(-1);
        ListNode pre = dum;
        if(l1==null && l2==null){
            return pre.next;
        }
        while (l1!=null || l2!=null){
            if(l1==null){
                pre.next = l2;
                break;
            }
            if(l2==null){
                pre.next = l1;
                break;
            }
            if(l1.val<=l2.val){
                pre.next = new ListNode(l1.val);
                pre = pre.next;
                l1 = l1.next;
            }
            if(l1.val>l2.val){
                pre.next = new ListNode(l2.val);
                pre = pre.next;
                l2 = l2.next;
            }
        }
        return pre.next;
    }
}
