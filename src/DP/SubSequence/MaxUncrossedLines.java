package DP.SubSequence;

/**
 * @Author 年年
 * @Date 2021/12/14 14:37
 * @Description
 * LeetCode-1035：最长不相交的线
 * 有两个数组，相同的数字可以用线连起来，最多能连多少条线？
 * 本质上是最长公共子序列的问题
 */
public class MaxUncrossedLines {
    /**
     * int[][] dp[i][j]表示nums1的前i个数字 和 nums2的前j个数字 最多可连线数
     * 递推公式：dp[i][j] = (nums1[i]==nums2[j])?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                dp[i][j] = (nums1[i-1]==nums2[j-1])?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
