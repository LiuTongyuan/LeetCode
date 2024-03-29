package DP.SubSequence;

/**
 * @Author 年年
 * @Date 2021/12/19 10:51
 * @Description 剑指OfferII-095:最长公共子序列
 * https://leetcode-cn.com/problems/qJnOS7/
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相
 * 对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 本质上是两个一维数组的dp问题
 */
public class LongestCommonSubSequence {
    /**
     * 方法一：dp
     * int[][] dp = new int[text1.length() + 1][text2.length() + 1];
     * dp[i][j] 表示 text1.subString(0,i)和text2.subString(0,j)的最长公共子序列的长度
     * 递推公式
     * 1.text1[i-1] == text2[j-1]
     * dp[i][j] = dp[i-1][j-1]+1
     * 2.text1[i-1] != text2[j-1]
     * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                dp[i][j] = (text1.charAt(i-1)==text2.charAt(j-1))?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    //可以空间优化
}
