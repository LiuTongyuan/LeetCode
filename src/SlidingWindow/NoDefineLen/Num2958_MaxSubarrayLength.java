package SlidingWindow.NoDefineLen;

import java.util.HashMap;

/**
 * @Author lty
 * @Date 2023/12/30 19:36
 * @Description 2958. 最多 K 个重复元素的最长子数组
 */
public class Num2958_MaxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < nums.length) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            if (count.get(nums[right]) <= k) {
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                while (nums[right] != nums[left]) {
                    count.put(nums[left], count.get(nums[left]) - 1);
                    left++;
                }
                count.put(nums[left], count.get(nums[left]) - 1);
                left++;
                right++;
            }
        }
        return maxLen;
    }
}
