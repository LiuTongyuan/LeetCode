package DP;

/**
 * @Author 年年
 * @Date 2021/12/19 9:46
 * @Description LeetCode-718:最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 两个一维数组的dp问题
 */
public class LongestSubArray {
    /**
     * int[][] dp = new int[nums1.length+1][nums2.length+1];
     * dp[i][j]表示以 nums1[i-1]和nums[j-1]为结尾的最长公共子数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                dp[i][j] = (nums1[i-1] == nums2[j-1])?(dp[i-1][j-1]+1):0;
                max =Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
