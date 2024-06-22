package SlidingWindow.NoDefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/30 20:48
 * @Description 1658. 将 x 减到 0 的最小操作数 1817
 */
public class Num1658_minOperations {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target < 0) {
            return -1;

        }
        int left = 0, right = 0, sum = 0, maxLen = -1;
        while (right < nums.length) {
            if (sum < target) {
                sum += nums[right++];
            } else if (sum == target) {
                maxLen = Math.max(maxLen, right - left);
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }
        }
        while (left < right) {
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
            sum -= nums[left++];
        }
        return maxLen == -1 ? maxLen : nums.length - maxLen;
    }
}
