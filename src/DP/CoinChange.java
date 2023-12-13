package DP;

import java.util.Arrays;

/**
 * @Author 年年
 * @Date 2021/12/28 19:34
 * @Description 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] == -1){
                continue;
            }
            for (int j = 0; j < coins.length&&coins[j]<dp.length-i; j++) {
                dp[i+coins[j]] = dp[i+coins[j]]==-1?dp[i]+1:Math.min(dp[i+coins[j]],dp[i]+1);
            }
        }
        return dp[dp.length-1];
    }
}
