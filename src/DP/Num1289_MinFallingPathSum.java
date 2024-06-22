package DP;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/8/10 10:43
 * @Description 1289. 下降路径最小和 II
 */
public class Num1289_MinFallingPathSum {
    public int minFallingPathSum(int[][] grid) {
        return m1(grid);
    }

    public int m1(int[][] grid) {
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

    /**
     * 思路2:每行仅有两个有效数字，最小的和第二小的
     * @param grid
     * @return
     */
    // public int m2(int[][] grid) {
    //     int min = 0x7fffffff,min2 = 0x7fffffff;
    // }


}
