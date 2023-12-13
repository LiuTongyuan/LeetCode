package DP.SubString;

/**
 * @Author 年年
 * @Date 2021/12/16 10:10
 * @Description LeetCode-409:最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i>j-2||dp[i+1][j-1];
                    if(dp[i][j]){
                        maxLength =Math.max(maxLength,j-i+1);
                    }
                }
            }
        }
        return maxLength;
    }
}
