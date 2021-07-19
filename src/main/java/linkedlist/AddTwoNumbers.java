package linkedlist;

/**
 * @Author yanwg
 * @Date 2021/6/1 9:21
 * @Description: 链表求和
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        ListNode cur1 = n1;
        ListNode cur2 = n2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;//用来标记进位
        while(cur1 != null && cur2 != null){
            int val = cur1.val + cur2.val + carry;//计算当前结果
            //判断是否产生进位
            if(val >= 10){
                val %= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            //生成新节点，并向后移动。
            cur.next = new ListNode(val);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //计算链表1或者链表2中尚未遍历的部分，思路同上。
        if(cur1 == null){
            while(cur2 != null){
                int val = cur2.val + carry;
                if(val >= 10){
                    val %= 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                cur.next = new ListNode(val);
                cur = cur.next;
                cur2 = cur2.next;
            }
        }else{
            while(cur1 != null){
                int val = cur1.val + carry;
                if(val >= 10){
                    val %= 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                cur.next = new ListNode(val);
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        //注意对最后的进位进行处理。
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;

    }



    public static void main(String[] args) {
        // 45
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(4);

        // 36
        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(3);


        // 原链表
        System.out.println(head1);
        System.out.println(head2);

        // 两链表求和 45+36=81   1-->8
        ListNode sumNode = addTwoNumbers(head1,head2);
        System.out.println(sumNode);

    }
}
