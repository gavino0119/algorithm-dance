package greedy;

/**
 * @Author yanwg
 * @Date 2021/5/16 10:28
 * @Description: 55. 跳跃游戏
 * 1. 依次更新每个位置可达
 * 2. 计算当前位置可达最远距离(maxL >= len ,即可返回结果)
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int canArr = 0;
        int maxStup = 0;
        for (int i = 0; i < len-1 ; i++) {
            if(maxStup>=len-1){
                return true;
            }
            canArr = Math.max(canArr,i+nums[i]-1);
            if(i<=canArr){
                maxStup = i+nums[i]-1;
            }
        }
        return maxStup>=len-1;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = {0};
        System.out.println(canJump(ints));
    }
}
