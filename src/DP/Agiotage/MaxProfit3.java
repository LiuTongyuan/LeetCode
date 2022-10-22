package DP.Agiotage;

/**
 * @Author 年年
 * @Date 2021/12/16 10:31
 * @Description
 * LeetCode-123:买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit3 {
    /**
     * 思路：因为最多买卖两次，所以需要找到两次最佳时机，也就是不相交的最大的差值
     * 难点：如何做到不交叉，
     * int[][2] dp[i][0] 表示以第i天为结束可以获得的最大的收益 dp[i][1] 表示以第i天为开始可以获得的最大的收益
     * 递推公式
     * dp[i][0] = Math.max(dp[i-1][0],prices[i]-minPrice)
     * dp[i][1] = Math.max(dp[i+1][1],maxPrice-prices[i])
     * 然后遍历以那一天为界限能获得的两次交易和最大
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] oneMaxProfit = new int[prices.length][2];
        int minPrice = prices[0];
        for (int i = 1; i < oneMaxProfit.length; i++) {
            oneMaxProfit[i][0] = Math.max(oneMaxProfit[i - 1][0], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        int maxPrice = prices[prices.length - 1];
        int maxPrices = 0;
        for (int i = oneMaxProfit.length - 2; i >= 0; i--) {
            oneMaxProfit[i][1] = Math.max(oneMaxProfit[i + 1][1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
            maxPrices = Math.max(maxPrices, oneMaxProfit[i][0] + oneMaxProfit[i][1]);
        }
        maxPrices = Math.max(maxPrices, oneMaxProfit[prices.length - 1][0] + oneMaxProfit[prices.length - 1][1]);
        return maxPrices;
    }

    /**
     * 最好的方法：考虑状态变化与状态之间的关系
     * buy1表示完成第一笔订单的买操作
     * sel1表示完成第一笔订单的卖操作
     * buy2表示完成第二笔订单的买操作
     * sel2表示完成第二笔订单的卖操作
     * <p>
     * 状态转移方程
     * buy1 = Math.max(buy1,-prices[i]),表示在今天完成买操作带来的收益
     * sel1 = Math.max(sel1,buy1 + prices[i])
     * buy2 = Math.max(buy2,sel1-prices[i]),表示在今天完成买操作带来的收益
     * sel2 = Math.max(sel2,buy2 + prices[i])
     *
     * @param prices
     * @return
     */
    public int maxProfitBest(int[] prices) {
        int buy1 = -prices[0], sel1 = 0, buy2 = -prices[0], sel2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sel1 = Math.max(sel1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sel1 - prices[i]);
            sel2 = Math.max(sel2, buy2 + prices[i]);
        }
        return sel2;
    }

    /**
     * 错误原因，未考虑交叉，以及递减后增大到一个更大的利润的问题，也就是说，一次遍历一定解决不掉问题
     *
     * @param prices
     * @return
     */
    public int maxProfitWrong(int[] prices) {
        int p1 = 0, p2 = 0;
        int minPrice = prices[0], maxPrice = prices[0];
        for (int i = 1; i < prices.length + 1; i++) {
            if (i < prices.length && prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                if (maxPrice - minPrice > p2) {
                    p2 = maxPrice - minPrice;
                    if (p1 < p2) {
                        int temp = p1;
                        p1 = p2;
                        p2 = temp;
                    }
                }
                if (i < prices.length)
                    minPrice = Math.min(prices[i], minPrice);
            }
        }
        return p1 + p2;
    }
}
