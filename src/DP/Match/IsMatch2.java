package DP.Match;

/**
 * @Author 年年
 * @Date 2021/12/19 10:00
 * @Description LeetCode-44:通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 *     s 可能为空，且只包含从 a-z 的小写字母。
 *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
public class IsMatch2 {
    /**
     * 方法一：本质上是两个一维数组的dp问题。
     * boolean[][] dp = new boolean[s.length()+1][p.length()+1];
     * dp[i][j] 表示s.subString(0,i)与p.subString(0,j)是否匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if(i == 0){
                    if(p.charAt(j-1) == '*'){
                        dp[i][j] = dp[i][j-1];
                    }
                    continue;
                }else if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
