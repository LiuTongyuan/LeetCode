package Greedy;

/**
 * @Author lty
 * @Date 2023/2/22 14:20
 * @Description 1140. 石子游戏 II
 * https://leetcode.cn/problems/stone-game-ii/
 */
public class Num1140_StoneGame2 {
    /**
     * 方法一：int[i][j] dp 代表爱丽丝从第i堆开始拿，最多可以拿j堆时爱丽丝最后最多能拿的数目；
     * dp[i][j] = Max(dp[i+k{1...j}]+Min(dp[i+1...2k][])
     * 本题有点像博弈论，两人都做出最优选择
     *
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length + 1][101];
        return 0;
    }
}
