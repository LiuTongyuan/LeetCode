package DP;

/**
 * @Author 年年
 * @Date 2021/12/15 11:14
 * @Description LeetCode-221:最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaxImalSquare {
    /**
     * 方法一：此题为二维数组的动态规划
     * int[][] dp[i][j]表示以坐标 <i,j> 为左上顶点组成的最大的正方形的边长
     * 递推公式：
     * dp[i][j] = (matrix[i][j]==1)?(Math.min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1]))+1:0
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1 || matrix[i][j] == '0') {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new MaxImalSquare().maximalSquare(arr));
    }
}
