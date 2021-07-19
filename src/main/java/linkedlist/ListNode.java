package linkedlist;

/**
 * @Author yanwg
 * @Date 2021/6/1 9:18
 * @Description:
 */
public class ListNode {
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
