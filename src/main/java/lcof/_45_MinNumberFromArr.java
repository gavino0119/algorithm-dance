package lcof;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/4/20 12:56
 * @Description: 把数组排成最小的数
 */
public class _45_MinNumberFromArr {
    /**
     * 自定义排序规则
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }
}
