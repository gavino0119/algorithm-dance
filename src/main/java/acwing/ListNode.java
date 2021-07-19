package acwing;

/**
 * @Author yanwg
 * @Date 2021/7/5 9:27
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
