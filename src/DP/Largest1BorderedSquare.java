package DP;

/**
 * @Author lty
 * @Date 2023/2/17 09:14
 * @Description 1139. 最大的以 1 为边界的正方形
 * https://leetcode.cn/problems/largest-1-bordered-square/
 */
public class Largest1BorderedSquare {
    /**
     * 方法一：动态规划
     * 思路解析：因为该正方形可以是空心，所以和其他的正方形是无关的，也就是说我们使用dp的地方只能是在求边长的时候。
     * 边界问题：
     * 1。初始 maxLength = 0，因为可能遇到一个矩阵全为0；
     * 2。初始 k = 0,因为需要保证得到的maxLength 可以取到1。
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int maxLength = 0;
        int[][][] side = new int[grid.length + 1][grid[0].length + 1][2];
        for (int i = grid[0].length - 1; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[j][i] == 1) {
                    side[j][i][0] = side[j + 1][i][0] + 1;// 纵向连续为1数目
                    side[j][i][1] = side[j][i + 1][1] + 1;// 横向连续为1数目
                } else {
                    side[j][i][0] = 0;
                    side[j][i][1] = 0;
                }

                int n = Math.min(side[j][i][0], side[j][i][1]);
                for (int k = 0; k < n; k++) {
                    if (Math.min(side[j + k][i][1], side[j][i + k][0]) > k) {
                        maxLength = Math.max(maxLength, k + 1);
                    }
                }
            }
        }

        return maxLength*maxLength;
    }

    public static void main(String[] args) {
        new Largest1BorderedSquare().largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
