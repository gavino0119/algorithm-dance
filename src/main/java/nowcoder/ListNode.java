package nowcoder;

/**
 * @Author yanwg
 * @Date 2022/1/17 11:01
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "-->" + val +
                " " + next +
                ' ';
    }
}
