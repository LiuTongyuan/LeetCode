package Week;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/4/26 19:28
 * @Description
 */
public class New4_26 {
    public static int three(int[] old, int tar) {
        // 0表示没使用过双倍，1表示使用过
        int[][] dp = new int[tar + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 200;
            dp[i][1] = 200;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < old.length; i++) {
            // 使用过双倍
            for (int j = tar; j >= old[i] / 2; j--) {
                // 之前没用，本次用
                if (j >= old[i]) {
                    dp[j][1] = Math.min(dp[j][1], dp[j - old[i]][0] + 1);
                }
                // 之前用本次没用
                dp[j][1] = Math.min(dp[j][1], dp[j - old[i] / 2][1] + 1);
                // 没使用过双倍
                dp[j][0] = Math.min(dp[j][0], dp[j - old[i] / 2][0] + 1);
            }
        }
        int min = Math.min(dp[tar][0], dp[tar][1]);
        return min > 102 ? -1 : min;
    }

    public static void main(String[] args) {
        int a  = three(new int[]{1, 2, 3, 4, 10}, 8);
        int b = a;
    }
}
