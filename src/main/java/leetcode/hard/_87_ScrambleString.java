package leetcode.hard;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/4/16 9:31
 * @Description: 扰乱字符串
 */
public class _87_ScrambleString {
    public boolean isScramble(String s1, String s2) {

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        for (int i = 0; i < s1.length(); i++) {
            if(chars[i]!=chars1[i]){
                return false;
            }
        }
        return true;
    }
}
