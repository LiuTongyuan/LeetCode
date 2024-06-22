package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2023/12/30 20:39
 * @Description 2401. 最长优雅子数组 1750
 */
public class Num2401_longestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int flag = Integer.MAX_VALUE;
        int left = 0, right = 0, maxLen = 0;
        while (right < nums.length) {
            while ((flag & nums[right]) != nums[right]) {
                flag += nums[left];
                left++;
            }
            flag -= nums[right];
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
