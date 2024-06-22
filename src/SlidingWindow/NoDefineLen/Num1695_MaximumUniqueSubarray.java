package SlidingWindow.NoDefineLen;

import java.util.HashMap;

/**
 * @Author lty
 * @Date 2023/12/29 16:52
 * @Description 1695. 删除子数组的最大得分 1529
 */
public class Num1695_MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (right < nums.length) {
            if (hashMap.getOrDefault(nums[right], -1) < left) {
                sum += nums[right];
                maxSum = Math.max(maxSum, sum);
            } else {
                for (int i = left; i < hashMap.get(nums[right]); i++) {
                    sum -= nums[i];
                }
                left = hashMap.get(nums[right]) + 1;
            }
            hashMap.put(nums[right], right);
            right++;
        }
        return maxSum;
    }
}
