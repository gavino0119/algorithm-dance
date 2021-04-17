package lcof;

/**
 * @Author yanwg
 * @Date 2021/4/17 10:44
 * @Description: 青蛙跳台阶II
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class _10_NumWaysII {
    /**
     * 超出时间限制
     * @param n
     * @return
     */
    public int numWays(int n) {
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        }
        return numWays(n-1)+numWays(n-2);
    }

    /**
     * 记忆化递归
     * @param n
     * @return
     */
    public int numWays1(int n) {
        int[] note = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            note[i] = -1;
        }
        return dfs(n,note);
    }
    private int dfs(int n,int[] note){
        if (note[n]!=-1) {
           return note[n] % 1000000007;
        }
        if(n==0){
            note[0] = 1;
        } else if(n==1){
            note[1] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            note[i] = dfs(i-1,note)+dfs(i-2,note);
        }
        return note[n] % 1000000007;
    }
}
