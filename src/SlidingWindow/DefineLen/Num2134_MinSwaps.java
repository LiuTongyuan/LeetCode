package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 19:39
 * @Description 2134. 最少交换次数来组合所有的 1 II
 */
public class Num2134_MinSwaps {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k += nums[i];
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }
        int maxCount = count;
        for (int i = k; i < nums.length + k - 1; i++) {
            count += nums[i % nums.length] - nums[i - k];
            maxCount = Math.max(maxCount, count);

        }
        return k - maxCount;
    }
}
