package DP.Rob;

/**
 * @Author 年年
 * @Date 2021/12/17 10:14
 * @Description LeetCode-213:打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻
 * 的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class Rob2 {
    /**
     * 方法一：dp
     * 问题本质：是一个有限制的dp问题，即首尾不能相接
     * int[][]
     * dp[i][0] 表示在不考虑首尾相接的情况下，从前i间(抢第i间)所能获得的最大的金额。
     * dp[i][0] 表示在不考虑首尾相接的情况下，从前i间(不抢第i间)所能获得的最大的金额。
     * 递推公式：
     * dp[i][0] = dp[i-1][1] + nums[i];
     * dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1])
     * <p>
     * 最后由于首位不能相接，需要遍历两次，
     * 一次默认nums[0] = 0，取Math.max(dp[length][0],dp[length][1])
     * 一次默认nums[0] = nums[0]，取Math.max(dp[length-1][0],dp[length-1][1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[2];
        int maxVal = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int old = dp[0];
            dp[0] = dp[1] + nums[i];
            dp[1] = Math.max(old, dp[1]);
        }
        maxVal = Math.max(dp[0],dp[1]);
        dp[0] = dp[1] = 0;
        for (int i = 1; i < nums.length; i++) {
            int old = dp[0];
            dp[0] = dp[1] + nums[i];
            dp[1] = Math.max(old, dp[1]);
        }
        maxVal = Math.max(maxVal,Math.max(dp[0],dp[1]));
        return maxVal;
    }
}
