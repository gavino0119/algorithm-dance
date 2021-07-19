package acwing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/7/5 9:23
 * @Description:
 */
public class _17 {
    public int[] printListReversingly(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for(int i=res.length-1;i>=0;i--){
            res[list.size()-1-i] = list.get(i);
        }
        return res;
    }

}
