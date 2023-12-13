package DP;

/**
 * @Author 年年
 * @Date 2021/12/17 10:47
 * @Description 剑指Offer-42:连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class MaxSubArray {
    /**
     * dp[i] 表示以nums[i]结尾的子数组的最大和
     * 由于dp[i]仅与dp[i-1]有关，所以可以空间优化
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int dp = Math.max(0,nums[0]);
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp+nums[i],0);
            max = Math.max(max,dp);
        }
        return max;
    }
    /**
     * 错误原因：注意审题，必须取一个
     * @param nums
     * @return
     */
    public int maxSubArrayWrong(int[] nums) {
        int dp = Math.max(0,nums[0]);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp+nums[i],0);
            max = Math.max(max,dp);
        }
        return max;
    }
}
