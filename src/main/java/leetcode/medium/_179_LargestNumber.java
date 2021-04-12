package leetcode.medium;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/4/12 9:32
 * @Description: 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 心得:  看到要求两个整数 x,y 如何拼接得到结果更大时，就想到先转字符串，然后比较 x+y 和 y+x。这是经验
 */
public class _179_LargestNumber {
    // 将数组内元素逐个转化为字符串后，直接通过compareTo方法比较
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String numsToWord[] = new String[n];
        for(int i=0;i<n;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord,(a, b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(numsToWord[i]);
        }
        String res = sb.toString();
        return res.charAt(0)=='0'?"0":res;
    }
}
