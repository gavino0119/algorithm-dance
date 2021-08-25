package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/8/18 9:27
 * @Description:
 */
public class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int tmp = 0;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=chars1.length-1;i>=0;i--){
            if (i>chars2.length) {
                stack.addFirst((int) chars1[i]);
            }
            for(int j=chars2.length-1;j>=0;j--){
                int s = chars1[i]+ chars2[j]+tmp;
                tmp = s-10>0?s-10:0;
                int val = s>10?1:s;
                stack.addFirst(val);
                break;
            }
        }
        if (chars1.length<chars2.length) {
            for(int i=0;i<chars2.length-chars1.length-2;i++){
                res.append(chars2[i]);
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pollFirst());
        }
        return res.toString();
    }


    /**
     * 官解
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}
