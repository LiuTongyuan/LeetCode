package DP.DifferentPath;

/**
 * @Author 年年
 * @Date 2021/12/19 9:10
 * @Description LeetCode-63:不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 是一个二维数组的遍历问题
 */
public class DifferentPath2 {
    /**
     * 方法一：dp
     * int[][] dp = new int[m + 1][n + 1];
     * dp[i][j]表示到达位置<i,j>的路径数目，因为每个位置都可以从上面到或者从左边到
     * 所以递推公式：
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (obstacleGrid[i - 1][j - 1] == 1) ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * 空间优化
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesWithSpaceOptimizi(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = (obstacleGrid[i - 1][j - 1] == 1) ? 0 : (dp[j] + dp[j - 1]);
            }
        }
        return dp[n];
    }
}
