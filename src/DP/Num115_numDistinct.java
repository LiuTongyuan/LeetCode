package DP;

/**
 * @Author lty
 * @Date 2024/4/3 13:20
 * @Description
 * 不同的子序列
 */
public class Num115_numDistinct {
    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] + dp[i - 1][j] : dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
