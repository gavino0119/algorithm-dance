package leetcode.easy;

/**
 * @Author yanwg
 * @Date 2021/5/31 17:17
 * @Description:
 */
public class _342_PowerOfFour {
    public boolean isPowerOfFour(int n) {

        if (n == 1) {
            return true;
        }


        while (n>1){
            if ((n&1)==1) {
                return false;
            }
            for (int i = 0; i < 2; i++) {
                n>>>=1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int x = 12;
        int ans = 0;
        while(x>0)
        {
            x-=x&-x;
            ans++;
        }
        System.out.println(ans);
    }
}
