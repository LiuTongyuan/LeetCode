package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 16:36
 * @Description 643. 子数组最大平均数 I
 */
public class Num643_FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }
        return max / (double) k;
    }
}
