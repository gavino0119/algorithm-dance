package company.boss;

/**
 * @author ywg
 * @version 1.0
 * @description 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * @date 2021/9/7 23:13
 */
public class SingleNumber {
    // 异或将相同的数约掉
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        for(int x: nums){
            res ^= x;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,2,3,4,5,5,4,8,9,9,1,1};
        System.out.println(singleNumber(arr));
    }


    /**
     * 扩展 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     * 可以采用三进制加法，将数的每一位做，不进位的加法
     */
    public int singleNumberEx(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        for(int i=0;i<32;i++){
            int sum = 0;
            for(int j=0;j<nums.length;j++){
                sum += ((nums[j]>>i) & 1);
            }
            res |= (sum % 3) << i;
        }
        return res;
    }

}
