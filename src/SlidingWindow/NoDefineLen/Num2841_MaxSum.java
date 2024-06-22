package SlidingWindow.NoDefineLen;

import java.util.HashMap;
import java.util.List;

/**
 * @Author lty
 * @Date 2023/12/29 17:23
 * @Description 2841. 几乎唯一子数组的最大和 1546
 */
public class Num2841_MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0, sum = 0, count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hashMap.put(nums.get(i), hashMap.getOrDefault(nums.get(i), 0) + 1);
            if (hashMap.get(nums.get(i)) == 1) {
                count++;
            }
            sum += nums.get(i);
        }
        if (count >= m) {
            maxSum = Math.max(sum, maxSum);
        }
        for (int i = k; i < nums.size(); i++) {
            if (!nums.get(i).equals(nums.get(i - k))) {
                hashMap.put(nums.get(i), hashMap.getOrDefault(nums.get(i), 0) + 1);
                hashMap.put(nums.get(i - k), hashMap.getOrDefault(nums.get(i - k), 0) - 1);
                sum += nums.get(i) - nums.get(i - k);
                if (hashMap.get(nums.get(i)) == 1) {
                    count++;
                }
                if (hashMap.get(nums.get(i - k)) == 0) {
                    count--;
                }
                if (count >= m) {
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}
