package DP;

/**
 * @Author 年年
 * @Date 2021/12/15 9:51
 * @Description LeetCode-1277:统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的正方形子矩阵的个数。
 */
public class CountSquares {
    /**
     * 方法一：此题为二维数组的动态规划
     * int[][] dp[i][j]表示以坐标 <i,j> 为左上顶点，可以组成几个正方形。
     * 我们可以知道，当以坐标 <i,j> 为左上顶点组成的最大的正方形的边长是k时，以坐标 <i,j> 为左上顶点，可以组成k个正方形。
     * 因此问题转化为求以坐标 <i,j> 为左上顶点组成的最大的正方形的边长
     * 递推公式：
     * dp[i][j] = (matrix[i][j]==1)?(Math.min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1]))+1:0
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int sum = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1 || matrix[i][j] == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                }

                sum += dp[i][j];
            }
        }
        return sum;
    }
}
