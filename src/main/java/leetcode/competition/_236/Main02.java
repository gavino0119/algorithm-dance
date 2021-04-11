package leetcode.competition._236;


/**
 * @author ywg
 * @version 1.0
 * @description 5727. 找出游戏的获胜者
 * DP  递推  约瑟夫环
 * @date 2021/4/11 10:45
 */
public class Main02 {
    public int findTheWinner(int n, int k) {
        return f(n,k)+1;
    }

    private int f(int n, int k){
        if (n == 1) return 0;
        return (k + f(n - 1, k)) % n;
    }
}
