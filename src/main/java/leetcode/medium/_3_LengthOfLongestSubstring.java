package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/8/3 9:29
 * @Description:
 */
public class _3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> queue = new LinkedList<>();
        int len = queue.size();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(queue.contains(c)){
                // 弹出
                while (queue.peekFirst()!=c){
                    queue.pollFirst();
                }
            }
            queue.addLast(c);
            len = Math.max(len,queue.size());
        }
        return len;
    }
}
