/**
 * @Author lty
 * @Date 2023/12/14 15:05
 * @Description 2132. 用邮票贴满网格图
 * https://leetcode.cn/problems/stamping-the-grid/description/
 */
public class Num2132_PossibleToStamp {
    /**
     * 二维差分
     *
     * @param grid
     * @param stampHeight
     * @param stampWidth
     * @return
     */
    // public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
    //     int h = grid.length;
    //     int w = grid[0].length;
    //     int[][] sum = new int[h + 1][w + 1];
    //     for (int i = 0; i < h; i++) {
    //         for (int j = 0; j < w; j++) {
    //             sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
    //         }
    //     }
    //     for (int i = 0; i < h - stampHeight + 1; i++) {
    //         for (int j = 0; j < w - stampWidth + 1; j++) {
    //
    //         }
    //     }
    //
    //
    // }
}
