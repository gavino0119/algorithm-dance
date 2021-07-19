package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/6/7 9:26
 * @Description: 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class _494_FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int way = 0;

        return way;
    }

    static int count = 0;

    /**
     * 回溯
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public static void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays1(arr, 3));
    }
}
