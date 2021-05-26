package company.bytedance;

/**
 * @Author yanwg
 * @Date 2021/4/20 13:23
 * @Description: 无重复字符的最长子串
 */
public class LongestSubstrWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[s.length()];


        int left = 0;
        int right = s.length();
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            left = i;
            while (left<right){

            }
        }
        return maxLen;
    }
}
