package DP.Rob;

/**
 * @Author 年年
 * @Date 2021/12/17 10:43
 * @Description LeetCode-198:打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的
 * 唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
 * 被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Rob1 {
    /**
     * 方法一：dp
     * int[][]
     * dp[i][0] 从前i间(抢第i间)所能获得的最大的金额。
     * dp[i][0] 从前i间(不抢第i间)所能获得的最大的金额。
     * 递推公式：
     * dp[i][0] = dp[i-1][1] + nums[i];
     * dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int old = dp[0];
            dp[0] = dp[1] + nums[i];
            dp[1] = Math.max(old, dp[1]);
        }
        return Math.max(dp[0],dp[1]);
    }
}
