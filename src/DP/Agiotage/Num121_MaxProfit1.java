package DP.Agiotage;

/**
 * @Author lty
 * @Date 2023/10/4 11:05
 * @Description LeetCode-121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class Num121_MaxProfit1 {
    /**
     * PS:最多完成一次交易，直接遍历即可
     * 双指针，左指针指向已遍历日期中最小买入价格，右指针指向当前天。
     *
     * @param prices prices[i]表示股票在第i天的价格。
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxIncome = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxIncome = Math.max(maxIncome, prices[i] - minPrice);
            }
        }
        return maxIncome;
    }
}
