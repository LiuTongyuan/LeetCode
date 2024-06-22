package SlidingWindow.DefineLen;

import java.util.*;

/**
 * @Author lty
 * @Date 2023/12/27 18:43
 * @Description 2841. 几乎唯一子数组的最大和
 */
public class Num2841_MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
        }
        long maxSum = 0;
        if (map.keySet().size() >= m) {
            maxSum = Math.max(maxSum, sum);
        }
        for (int i = k; i < nums.size(); i++) {
            sum += nums.get(i) - nums.get(i - k);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if (map.get(nums.get(i - k)) == 1) {
                map.remove(nums.get(i - k));
            } else {
                map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
            }
            if (map.keySet().size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
