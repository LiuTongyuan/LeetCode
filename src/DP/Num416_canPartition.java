package DP;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/5/1 20:22
 * @Description
 */
public class Num416_canPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int[] dp = new int[((sum) / 2 + 31) / 32];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = num % 32;
            int m = num / 32;
            for (int j = dp.length - 1; j >= 0; j--) {

            }
        }
        return false;
    }
}
