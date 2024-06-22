package SlidingWindow.NoDefineLen;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2023/12/30 20:11
 * @Description 1438. 绝对差不超过限制的最长连续子数组 1672
 */
public class Num1438_longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int left = 0, right = 0, maxLen = 0;
        while (right < nums.length) {
            maxHeap.add(nums[right]);
            minHeap.add(nums[right]);

            while (maxHeap.peek() - minHeap.peek() > limit) {
                maxHeap.remove(nums[left]);
                minHeap.remove(nums[left]);
                left++;
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
