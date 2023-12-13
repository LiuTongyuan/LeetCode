package DP.Match;

/**
 * @Author 年年
 * @Date 2021/12/18 9:56
 * @Description 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *     '.' 匹配任意单个字符
 *     '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 本质上是两个一维数组的dp问题
 */
public class IsMatch1 {
    /**
     * 方法一：dp
     * 对于两个一维数组的dp问题，常用 dp[i][j] 表示第一个数组的前i个元素和
     * 第二数组的前j个元素是否满足我们的要求
     * <p>
     * 递推公式：
     * 有三种情况
     * p[j] 为英文字母 dp[i][j] 取决于s[i]和p[j]
     * p[j] 为., 此时 dp[i][j] = dp[i-1][j-1]
     * p[j] 为*, 此时 需判断p[j-1]和s[i]之间的关系，如果相等，则可以匹配，也可以不匹配
     * dp[i][j] = dp[i-1][j]||dp[i][j-2],不相等则dp[i][j] = dp[i][j-2]
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (i == 0) {
                    if (p.length() > 1 && p.charAt(j - 1) == '*')
                        dp[i][j] = dp[i][j - 2];
                    continue;
                }
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
