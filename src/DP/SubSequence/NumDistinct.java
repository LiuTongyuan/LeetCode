package DP.SubSequence;

/**
 * @Author lty
 * @Date 2022/10/21 11:23
 * @Description 剑指 Offer II 097. 子序列的数目
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 */
public class NumDistinct {
    public static void main(String[] args) {
        new NumDistinct().numDistinct2("rabbbit", "rabbit");
    }
    /**
     * 方法一：动态规划
     * int[][] dp = new int[s.length()][t.length()];其中dp[i][j]
     * 表示s.subString(i)的子序列中t.subString(j)出现的次数
     * 所以递推方程如下：
     * 1. s.charAt(i) == t.charAt(j)
     * dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
     * 2. s.charAt(i) != t.charAt(j)
     * dp[i][j] = dp[i-1][j]
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * 优化思路：
     * 可以看到其依赖关系为 dp[i][j] 需要 dp[i-1][j] 、 dp[i-1][j-1];
     * 如果省略 i 则变为 j 需要 j 、 j-1，可以使用一维数组解决；
     * 注意：
     * 此时 j 需从大到小遍历，因为 dp[i][j] 需要使用 dp[i-1][j-1]，如果顺序遍历，此时 dp[j-1] 相当于被更新为 dp[i][j-1]，则逻辑错误。
     */
    public int numDistinct2(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = t.length(); j>=1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
