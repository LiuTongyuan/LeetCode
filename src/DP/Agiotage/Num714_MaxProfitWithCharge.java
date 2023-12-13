package DP.Agiotage;

/**
 * @Author 年年
 * @Date 2021/12/17 9:05
 * @Description
 * LeetCode-714:买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Num714_MaxProfitWithCharge {
    /**
     * 思路：采用状态转换与前一天的状态有关
     * int[][] dp[prices.length][2]
     * dp[i][0]代表第i天交易完成后手里有股票时的最大收益
     * 此时有两种情况：1.前一天手里有股票 2.前一天手里没有股票，今天买
     * dp[i][1]代表第i天交易完成后手里没有股票时的最大收益
     * 此时有两种情况：1.前一天手里没有股票 2.前一天手里有股票，今天卖
     * <p>
     * 由于有手续费，可以在买的时候减去手续费也可以在卖出时减
     * 递推公式：在卖的时候减去手续费
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
     * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }

    //下列代码错误原因，既然决定在买的时候减去手续费，那初始化第一次买入的时候就也要减去，不然和自己的定义就不一致了
    public int maxProfitWrong(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public int maxProfitSpaceOptimize(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int oldBuy = dp[0];
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], oldBuy + prices[i] - fee);
        }
        return dp[1];
    }
}
