package leetcode.competition._241;

/**
 * @Author yanwg
 * @Date 2021/5/16 10:26
 * @Description: 5759. 找出所有子集的异或总和再求和
 * 求异或  n = 5 ^ 6
 */
public class Main01 {
    public int subsetXORSum(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (tmp !=0 ) {
                    sum += tmp ^ nums[j];
                }
                tmp = nums[i] ^ nums[j];
                sum += tmp;
            }
        }
        return sum;
    }
}
