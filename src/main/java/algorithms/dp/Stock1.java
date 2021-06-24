package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.16
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/mai-gu-piao-de-zui-jia-shi-ji-yi-ci-bian-3jjc/
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 *
 * https://leetcode-cn.com/circle/article/qiAgHn/  股票系列
 */
public class Stock1 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }

        return max;
    }
}
