package DP.Agiotage;

/**
 * @Author 年年
 * @Date 2021/12/16 11:52
 * @Description LeetCode-188:买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Num188_MaxProfit4 {
    /**
     * dp[k][0]表示最多完成第k次交易所能获得的最大利润（此时手里拥有股票）dp[k][1]表示最多完成第k次交易所能获得的最大利润（此时手里没有股票）
     * 那么在第i天时，递推公式为：
     * dp[k][0] = max(dp[k-1][1]-prices[i],dp[k][0])
     * dp[k][1] = max(dp[k][0]+prices[i],dp[k][1])
     * 由于存在k-1，需要额外考虑k=0的情况
     * dp[0][0] = max(-prices[i],dp[0][0])
     * dp[0][1] = max(dp[0][0]+prices[i],dp[0][1])
     * 另外需考虑赋值顺序的问题（我们在构建dp公式时忽略了i，相当于已经做了空间优化）
     *
     * @param k      最大买入次数
     * @param prices prices[i]表示股票在第i天的价格。
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(-prices[i], dp[0][0]);
            dp[0][1] = Math.max(dp[0][0] + prices[i], dp[0][1]);
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j - 1][1] - prices[i], dp[j][0]);
                dp[j][1] = Math.max(dp[j][0] + prices[i], dp[j][1]);
            }
        }
        return dp[k - 1][1];
    }
}
