package DP;

/**
 * @Author 年年
 * @Date 2021/12/15 10:58
 * @Description 剑指Offer-47:礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘
 * 的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 本质上很像是背包问题，因为每次有两个选择，向上走向下走
 */
public class MaxGiftValue {
    /**
     * 方法一：
     * int[][] dp[i][j]表示 从<i,j>位置开始走，最多拿到的礼物价值
     * 递推公式：
     * dp[i][j] = grid[i][j] + Math.max(dp[i][j+1],dp[i+1][j]);
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.max(dp[j + 1], dp[j]);
                }
            }
        }
        return dp[0];
    }
}
