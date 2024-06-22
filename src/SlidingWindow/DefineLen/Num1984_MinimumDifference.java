package SlidingWindow.DefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/27 16:32
 * @Description 1984. 学生分数的最小差值
 */
public class Num1984_MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - k + 1]);
        }
        return minDiff;
    }
}
