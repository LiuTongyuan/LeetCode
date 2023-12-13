package DP.SubString;

/**
 * @Author 年年
 * @Date 2021/12/14 10:36
 * @Description
 * 牛客-127：最长公共子串
 * 给定两个字符串，找出他们的最长公共子串的长度
 */
public class LongestCommonSubstring {
    /**
     * 方法一：int dp[i][j]表示以str1[i]和str2[j]为最后一个元素的最长公共子串的长度
     * 递推公式 dp[i][j] = str1[i]==str2[j]?dp[i-1][j-1]+1:0;
     * 可直接使用空间优化
     * @param str1
     * @param str2
     * @return
     */
    public String LCS (String str1, String str2) {
        int[] dp = new int[str2.length()];
        String lcs = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = str2.length()-1; j >=0; j--) {
                dp[j] = (str1.charAt(i)==str2.charAt(j))?((j-1>=0)?dp[j-1]:0)+1:0;
                if(dp[j]>lcs.length()){
                    lcs = str2.substring(j-dp[j]+1,j+1);
                }
            }
        }
        return lcs;
    }
}
