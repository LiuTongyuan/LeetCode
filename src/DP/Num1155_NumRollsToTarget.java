package DP;

/**
 * @Author lty
 * @Date 2023/10/24 09:43
 * @Description 1155. 掷骰子等于目标和的方法数
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/
 */
public class Num1155_NumRollsToTarget {
    public static void main(String[] args) {
        numRollsToTarget2(30, 30, 500);
    }

    /**
     * 题解：常规的dp（进行了空间优化，无优化应该是用的二位数组）
     *
     * @param n
     * @param k
     * @param target
     * @return
     */
    public int numRollsToTarget(int n, int k, int target) {
        long[] dp = new long[target + 1];
        for (int i = 1; i < k + 1 && i < dp.length; i++) {
            dp[i] = 1;
        }
        // 投掷n次
        for (int i = 1; i < n; i++) {
            // 遍历可能的数字
            for (int j = target; j > 0; j--) {
                dp[j] = 0;
                // 遍历此次投掷的结果
                for (int l = 1; l <= k && l < j; l++) {
                    dp[j] += dp[j - l];
                }
                dp[j] %= 1000000007;
            }
        }
        return (int) dp[target];
    }

    /**
     * 题解：进行时间优化，剪枝
     * dp[n] 用到了 dp[n-1].dp[n-2]...dp[n-k]
     * dp[n-1] 用到了 dp[n-2].dp[n-3]...dp[n-k-1]
     * dp[n]new = dp[n-1]old - dp[n-k-1]old + dp[n-1]new
     * dp[n-1]new =
     *
     * @param n
     * @param k
     * @param target
     * @return
     */
    public static int numRollsToTarget2(int n, int k, int target) {
        long[] dp = new long[target + 1];
        for (int i = 1; i < k + 1 && i < dp.length; i++) {
            dp[i] = 1;
        }
        // 投掷n次
        for (int i = 1; i < n; i++) {
            long sum = 0, buf = 0;
            // 遍历可能的数字
            for (int j = 1; j < target+1; j++) {
                buf = dp[j];
                dp[j] = sum;
                sum += buf - (j > k ? dp[j - k] : 0);
                sum %= 1000000007;
            }
        }
        return (int) dp[target];
    }
}
