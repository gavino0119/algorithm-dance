package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/5/26 9:22
 * @Description: 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果
 * 注意，您的结果中 不应 包含任何括号。
 * "(u(love)i)" ----- (uevoli)------ iloveu
 * "(ed(et(oc))el)" --- (ed(etco)el) --- (edocteel) --- leetcode
 */
public class _1190_ReverseParentheses {
    /**
     * LeetCode 1
     * @param s
     * @return
     */
    public String reverseParentheses1(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");
        StringBuilder we = stringBuilder.insert(0, "we");
        System.out.println(we);
        stringBuilder.setLength(0);
        System.out.println("x"+we);
    }
}
