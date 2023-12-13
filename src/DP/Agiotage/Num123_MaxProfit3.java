package DP.Agiotage;

/**
 * @Author 年年
 * @Date 2021/12/16 10:31
 * @Description LeetCode-123:买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Num123_MaxProfit3 {
    /**
     * 方法一：顺逆两次遍历
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
        // 求以第i天为 结束 可以获得的最大收益，用 第i天的价格 - 之前的最小价格
        for (int i = 1; i < oneMaxProfit.length; i++) {
            oneMaxProfit[i][0] = Math.max(oneMaxProfit[i - 1][0], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        int maxPrice = prices[prices.length - 1];
        int maxPrices = 0;
        // 求以第i天为 开始 可以获得的最大收益，用 之后的最大价格 - 第i天的价格
        for (int i = oneMaxProfit.length - 2; i >= 0; i--) {
            oneMaxProfit[i][1] = Math.max(oneMaxProfit[i + 1][1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
            // 遍历以第i天为开始可以获得的最大收益时，可以顺便把最后的最大利润求出来
            maxPrices = Math.max(maxPrices, oneMaxProfit[i][0] + oneMaxProfit[i][1]);
        }
        maxPrices = Math.max(maxPrices, oneMaxProfit[prices.length - 1][0] + oneMaxProfit[prices.length - 1][1]);
        return maxPrices;
    }

    /**
     * 方法二：通用dp
     * 思路：第2次交易需要第1次交易完成， 第i次交易需要第i-1次交易完成。
     * int[][] dp[i][j] 表示在第j天前 最多完成i次交易 所获的最大利润
     * 递推公式
     * 可以分为两种情况，第j天进行交易或不进行交易，取利润大的情况即可
     * dp[i][j] = Math.max(dp[i][j-1],dp[i-1][k] + prices[j] - prices[k+1] 「k=0...j-2」)
     * 表示在前k天完成了i-1笔交易后，k+1天到第j天完成一笔交易
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        // i代表完成几次交易，从1开始递归
        for (int i = 1; i < dp.length; i++) {
            // j表示交易天数，第0天不能完成交易
            for (int j = 1; j < dp[i].length; j++) {
                int max = Math.max(0, prices[j] - prices[0]);
                for (int k = 1; k <= j - 1; k++) {
                    //上一次买入为第k天，则需在第k-1天前完成前i-1次
                    max = Math.max(max, dp[i - 1][k - 1] + prices[j] - prices[k]);
                }
                dp[i][j] = Math.max(max, dp[i][j - 1]);
            }
        }
        return dp[2][prices.length - 1];
    }

    /* maxProfit2另一种写法
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        // k是交易的次数，从1开始，如果是0表示没有交易，这个不需要计算
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < prices.length; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    int max = 0;
                    if (k == 0) {
                        // 递推公式的边界条件判断，k等于0表示在第一天买入，第j天卖出，这种情况下我们最多
                        // 进行一次股票交易，所以不需要dp[i - 1][k - 1]。
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k]);
                    } else {
                        // 递推公式 //要么第j天不进行任何操作，要么第j天卖出一支股票。如果卖出股票我们需要找到卖出
                        // 股票的最大利润（注意这里k不一定是买入股票最低价的那天，这里的最大利润还需要
                        // 包含前面交易的利润，所以是prices[j] - prices[k] + dp[i - 1][k - 1]）
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k] + dp[i - 1][k - 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[2][prices.length - 1];
    }
     */

    /**
     * 方法二：优化递推公式
     * 在上述递推公式中，由于存在 dp[i-1][k] + prices[j] - prices[k+1] 「k=0...j-2」，遍历复杂度太高
     * 但是经过观察，你会发现 prices[j] 针对j天不变，
     * 剩下的部分可以考虑为 Math.max(dp[i-1][k] - prices[k+1]), k < j-1,这一部分可以在前面计算dp[i][k+1]时保存
     * 使用一个max局部变量进行记录 max = Math.max(max, dp[i-1][j-1] - prices[j])
     *
     * @param prices
     * @return
     */
    public int maxProfit2opt(int[] prices) {
        int[][] oneMaxProfit = new int[prices.length][3];

        return 0;
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
                if (i < prices.length) {
                    minPrice = Math.min(prices[i], minPrice);
                }
            }
        }
        return p1 + p2;
    }

    public static void main(String[] args) {
        new Num123_MaxProfit3().maxProfit2(new int[]{1, 4, 2});
    }
}
