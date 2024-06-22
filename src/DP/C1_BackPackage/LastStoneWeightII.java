package DP.C1_BackPackage;

/**
 * @Author 年年
 * @Date 2021/12/14 14:17
 * @Description LeetCode-1049：最后一块石头的重量 II
 * 每次选出两块石头相撞，剩下x-y。直到最后只剩一块石头，问这块最小是多少
 * 数组元素分为两个子集，让他们的和之差最小
 * 本质上是01背包问题，寻找一个最接近sum/2的值
 */
public class LastStoneWeightII {
    /**
     * 01背包问题
     * boolean[][] dp[i][j]表示前i个数中是否存在和为j的组合
     * 递推公式：dp[i][j] = dp[i-1][j] || ((j-stones[i])>=0)?dp[i-1][j-stones[i]]:false;
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = dp[j] || (((j-stones[i])>=0)?dp[j-stones[i]]:false);
            }
        }
        for (int i = target; i >= 0; i--) {
            if(dp[i]){
                return sum-2*i;
            }
        }
        return sum;
    }
}
