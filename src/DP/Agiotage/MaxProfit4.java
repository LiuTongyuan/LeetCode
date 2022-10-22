package DP.Agiotage;

/**
 * @Author 年年
 * @Date 2021/12/16 11:52
 * @Description
 * LeetCode-188:买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit4 {
    /**
     * 参考 两笔交易的 状态改变算法
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] + prices[i]);
            }
        }
        return dp[k - 1][1];
    }
}
