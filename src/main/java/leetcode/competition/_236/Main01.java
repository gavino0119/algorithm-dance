package leetcode.competition._236;

/**
 * @Author yanwg
 * @Date 2021/4/11 10:35
 * @Description: 5726. 数组元素积的符号
 */
public class Main01 {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for (int n : nums){
            if (n==0){
                return 0;
            } else if(n<0){
                cnt++;
            }

        }
        if(cnt%2==0){
            return 1;
        } else {
            return -1;
        }
    }
}
