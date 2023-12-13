package DP.SubSequence;

/**
 * @Author 年年
 * @Date 2021/12/15 11:33
 * @Description LeetCode-516:最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 涉及回文的问题，一般考虑两边与中间的关系
 */
public class LongestPalindromeSubseq {
    /**
     * 方法一：
     * int[][] dp[i][j]表示以s.subString(i,j)构成的子字符串的最大回文子序列的长度
     * 递推公式
     * s.charAt(i) == s.charAt(j-1) -> dp[i][j] = (i == j - 1) ? 1 : dp[i + 1][j - 1] + 2;
     * s.charAt(i) != s.charAt(j-1) -> dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    dp[i][j] = (i == j - 1) ? 1 : dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length()];
    }
}
