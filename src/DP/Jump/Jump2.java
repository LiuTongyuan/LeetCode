package DP.Jump;

/**
 * @Author 年年
 * @Date 2021/12/24 12:03
 * @Description 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump2 {
    /**
     * 方法一：dp
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j - i <= nums[i] && j < nums.length; j++) {
                dp[i] = Math.min(dp[i] - 1, dp[j]) + 1;
            }
        }
        return dp[0];
    }
}
