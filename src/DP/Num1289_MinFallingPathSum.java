package DP;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/8/10 10:43
 * @Description
 */
public class Num1289_MinFallingPathSum {
    public int minFallingPathSum(int[][] grid) {
        int[] sum = new int[grid.length];
        int[] sum_temp = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            sum[i] = grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                sum_temp[j] = Integer.MAX_VALUE;
                for (int k = 0; k < grid.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    sum_temp[j] = Math.min(sum_temp[j], sum[k] + grid[i][j]);
                }
            }
            int[] buf = sum;
            sum = sum_temp;
            sum_temp = buf;
        }
        return Arrays.stream(sum).min().getAsInt();
    }
}
