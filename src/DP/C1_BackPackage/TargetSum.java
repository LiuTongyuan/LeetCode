package DP.C1_BackPackage;

/**
 * @Author 年年
 * @Date 2021/12/14 9:15
 * @Description
 * LeetCode-494：目标和
 * 数组中目标和组合数目，每个数字只能用一次
 * 本质上是01背包问题
 */
public class TargetSum {
    //方法一：dfs
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    public int dfs(int[] nums, int target, int startIndex) {
        if (startIndex == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int res = 0;
        res += dfs(nums, target + nums[startIndex], startIndex + 1);
        res += dfs(nums, target - nums[startIndex], startIndex + 1);
        return res;
    }

    /**
     * 方法二：int[][] dp[i][j] 表示前i个数中相加和为j的组合的数目
     * 递推公式：dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
     *
     * @param nums
     * @param target
     * @return
     */
    public int targetSumDP(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        int delSum = (sum - target) >> 1;
        int[][] dp = new int[nums.length + 1][delSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + (j - nums[i - 1] >= 0 ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[nums.length][delSum];
    }

    /**
     * 方法三：int[] dp[j] 表示前i个数中相加和为j的组合的数目 空间优化
     * 递推公式：dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
     *
     * @param nums
     * @param target
     * @return
     */
    public int targetSumDP_spaceOptimize(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum - target) < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        int delSum = (sum - target) >> 1;
        int[] dp = new int[delSum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = delSum; j >= 0; j--) {
                dp[j] = dp[j] + (j - nums[i] >= 0 ? dp[j - nums[i]] : 0);
            }
        }
        return dp[delSum];
    }
}
