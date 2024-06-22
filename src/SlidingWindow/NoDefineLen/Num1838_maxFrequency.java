package SlidingWindow.NoDefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/1/1 14:45
 * @Description 1838. 最高频元素的频数 1876
 */
public class Num1838_maxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1, maxFre = 1;
        long diff = 0;
        while (right < nums.length) {
            diff += (long)(nums[right] - nums[right - 1]) * (long)(right - left);
            while (diff > k) {
                diff -= nums[right] - nums[left++];
            }
            right++;
            maxFre = Math.max(maxFre, right - left);
        }

        return maxFre;
    }
}
