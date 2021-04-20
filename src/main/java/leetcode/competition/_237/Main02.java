package leetcode.competition._237;

import java.util.Arrays;

/**
 * @author ywg
 * @version 1.0
 * @description leetcode -- 5735. 雪糕的最大数量
 * @date 2021/4/18 10:39
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 */
public class Main02 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) {
                return cnt;
            }else {
                coins -= costs[i];
                cnt ++;
            }
        }
        return cnt;
    }
}
