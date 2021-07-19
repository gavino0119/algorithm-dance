package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/5/28 9:02
 * @Description: 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class _477_TotalHammingDistance {
    /**
     * 暴力超时
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += getHammingDistance(nums[i],nums[j]);
            }
        }
        return sum;
    }

    private int getHammingDistance(int num1,int num2){
        int distance = 0;
        int num = num1 ^ num2;
        while(num!=0){
            distance++;
            num = num & (num-1);
        }

        return distance;
    }
}
