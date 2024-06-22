package DP;

/**
 * @Author lty
 * @Date 2023/12/13 15:46
 * @Description 2617. 网格图中最少访问的格子数
 * https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/description/
 */
public class Num2617_MinimumVisitedCells {
    /**
     * AC-99%，但是会超时，因为有些节点多次进入
     * @param grid
     * @return
     */
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= grid[i][j]; k++) {
                    if (i + k < m) {
                        dp[i + k][j] = dp[i + k][j] == 0 ? dp[i][j] + 1 : Math.min(dp[i + k][j], dp[i][j] + 1);
                    }
                    if (j + k < n) {
                        dp[i][j + k] = dp[i][j + k] == 0 ? dp[i][j] + 1 : Math.min(dp[i][j + k], dp[i][j] + 1);
                    }

                }
            }

        }
        return dp[m - 1][n - 1] == 0 ? -1 : dp[m - 1][n - 1];

    }

    /**
     * 优化思路：并查集
     * 对于一行，或者一列，当该节点首次进入时，此时经过的格点一定是最少的。
     * 可以针对行/列做一个并查集，当访问到
     */
}
