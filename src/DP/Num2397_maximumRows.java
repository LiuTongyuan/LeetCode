package DP;

/**
 * @Author lty
 * @Date 2024/1/4 10:03
 * @Description 2397. 被列覆盖的最多行数 1719
 */
public class Num2397_maximumRows {
    // public static void main(String[] args) {
    //     new Num2397_maximumRows().maximumRows(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}}, 2);
    // }

    /**
     * 思路：其实就是未选的列的有1的行要最少，
     * 问题转化为选择 n-numSelect 列，让他们的或最后留存的1最少。
     *
     * @param matrix
     * @param numSelect
     * @return
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int target = n - numSelect;
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                col[j] |= (matrix[i][j] << i);
            }
        }
        int[] dp = new int[1 << n];
        int minBit = m;
        for (int i = 1; i < dp.length; i++) {
            int bitCount = Integer.bitCount(i);
            if (bitCount > target) {
                continue;
            }
            dp[i] = dp[i & (i - 1)] | col[op(i)];

            if (bitCount == target) {
                minBit = Math.min(Integer.bitCount(dp[i]), minBit);
            }
        }
        return target == 0 ? minBit : m - minBit;
    }

    public int op(int num) {
        int res = 0;
        while ((num & 1) == 0) {
            num >>>= 1;
            res++;
        }
        return res;
    }
}
