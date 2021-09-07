package company.boss;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description  数组中的重复数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 * @date 2021/9/7 23:04
 */
public class FindDuplicates {
    // 这里因为 数值都是 1~n 可以将其散列在长度为n的数组中
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        // 可以将字符的添加增加到遍历中
        for(int x: nums){
            int index = Math.abs(x) - 1;
            nums[index] = -nums[index];
            if(nums[index] > 0){
                res.add(Math.abs(x));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,4,5,6,6,7,8,5};
        System.out.println(findDuplicates(arr));
    }

}
