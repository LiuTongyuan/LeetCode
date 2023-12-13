package DP.DifferentPath;

/**
 * @Author 年年
 * @Date 2021/12/19 9:27
 * @Description LeetCode-62:不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class DifferentPath1 {
    /**
     * 方法一：dp
     * int[][] dp = new int[m + 1][n + 1];
     * dp[i][j]表示到达位置<i,j>的路径数目，因为每个位置都可以从上面到
     * 或者从左边到
     * 所以递推公式：
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    /**
     * 空间优化
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsWithSpaceOptimizi(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 方法二：公式计算
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsWithExpression(int m, int n) {
        int total = m + n - 2;
        int choose = Math.min(m, n) - 1;
        long a = 1, b = 1;
        for (int i = 1; i <= choose; i++) {
            a *= total - choose + i;
            b *= i;
        }
        return (int)(a/b);
    }
}
