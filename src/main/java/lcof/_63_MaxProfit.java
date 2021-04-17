package lcof;

/**
 * @Author yanwg
 * @Date 2021/4/17 11:21
 * @Description: 股票的最大利润
 */
public class _63_MaxProfit {
    /**
     * 爆搜
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
    }

    /**
     * 维护一个历史最小值，只计算当天获利最大值
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int max = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(prices[i],low);
            max = Math.max(prices[i]-low,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{1, 2}));
    }
}
