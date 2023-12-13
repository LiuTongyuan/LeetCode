package DP.Parentheses;

/**
 * @Author 年年
 * @Date 2021/12/24 10:37
 * @Description 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {
    /**
     * 方法一：dp
     * boolean[][] dp = new boolean[s.length()][s.length()];
     * dp[i][j] 表示 s.subString(i,j+1)是否括号匹配
     * dp[i][j] = dp[i+2][j]||dp[i][j-2]||dp[i+1][j-1]
     * <p>
     * 错误原因：
     * “(())(())”这种时会出错，因为j位置的)不一定和i或者j-1位置的(匹配,也可能和其他位置的(匹配。
     * 我考虑的()在两端不会出现，而中间则不匹配
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_Wrong(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlength = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((j - i) % 2 == 0) {
                    continue;
                }
                if (j - i > 2) {
                    dp[i][j] = (s.charAt(i) == '(' && s.charAt(i + 1) == ')' && dp[i + 2][j]) ||
                            (s.charAt(j - 1) == '(' && s.charAt(j) == ')' && dp[i][j - 2]) ||
                            (s.charAt(i) == '(' && s.charAt(j) == ')' && dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = s.charAt(i) == '(' && s.charAt(j) == ')';
                }
                if (dp[i][j])
                    maxlength = Math.max(maxlength, j - i + 1);
            }
        }
        return maxlength;
    }

    /**
     * 方法二：dp
     * int[] dp = new boolean[s.length()+1];
     * dp[i] 表示以 s.charAt(i-1)结尾的最长匹配长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        int maxLength = 0;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    // i=5 dp[4] = 2,则012345
                    dp[i] = (i - dp[i - 1] - 2) >= 0 && s.charAt(i - dp[i - 1] - 2) == '(' ? dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 : 0;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}
