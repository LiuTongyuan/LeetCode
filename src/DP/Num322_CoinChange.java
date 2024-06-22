package DP;

import java.util.*;

/**
 * @Author 年年
 * @Date 2021/12/28 19:34
 * @Description 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Num322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int a = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (int j = 0; j < coins.length && coins[j] < dp.length - i; j++) {
                dp[i + coins[j]] = dp[i + coins[j]] == -1 ? dp[i] + 1 : Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }


    public static int one(int[] xp) {
        Arrays.sort(xp);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < xp.length / 2; i++) {
            set.add(xp[i] + xp[xp.length - 1 - i]);
        }
        return set.size();
    }

    public static int[] two(int[] power, int[] min, int[] max) {
        Arrays.sort(power);
        int[] preSum = new int[power.length];
        int[] res = new int[min.length];
        int sum = 0;
        for (int i = 0; i < power.length; i++) {
            sum += power[i];
            preSum[i] = sum;
        }
        for (int i = 0; i < min.length; i++) {
            res[i] = preSum[find(power, max[i])] - preSum[find(power, min[i] - 1)];
        }
        return res;

    }

    public static int find(int[] power, int tar) {
        int l = 0, r = power.length;
        // 最后的l一定比他小
        while (r - l != 1) {
            int mid = l + (r - l) / 2;
            if (power[mid] <= tar) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
