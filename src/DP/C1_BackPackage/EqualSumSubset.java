package DP.C1_BackPackage;

/**
 * @Author 年年
 * @Date 2021/12/14 9:52
 * @Description
 * LeetCode-416：等和子集
 * 数组元素是否可以分为两个等和子集
 * 本质上是01背包问题
 */
public class EqualSumSubset {
    /**
     * 方法一：与目标和同理，求出sum，判断sum是否是偶数，目标为sum/2
     * boolean[][] dp[i][j] 表示前i个数中是否存在相加和为j的组合
     * 递推公式：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
     * 直接使用空间优化
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = dp[j] || (j - nums[i] >= 0 ? dp[j - nums[i]] : false);
            }
        }
        return dp[target];
    }
}
