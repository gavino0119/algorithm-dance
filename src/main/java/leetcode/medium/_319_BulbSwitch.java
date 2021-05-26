package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/4/19 13:06
 * @Description: 灯泡开关
 * 找出 n 轮后有多少个亮着的灯泡
 */
public class _319_BulbSwitch {
    public int bulbSwitch(int n) {
        if (n==0){
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return 0;
    }
}
