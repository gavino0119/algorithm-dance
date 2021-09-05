package linkedlist;

/**
 * @Author yanwg
 * @Date 2021/6/1 9:18
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "-->" + val +
                " " + next +
                ' ';
    }
}
