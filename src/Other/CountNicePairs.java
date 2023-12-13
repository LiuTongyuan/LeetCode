package Other;

import java.util.HashMap;

/**
 * @Author lty
 * @Date 2023/1/17 12:53
 * @Description
 */
public class CountNicePairs {
    /**
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
     * 可以转化为 nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
     * 只需统计 nums[i] - rev(nums[i])即可
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        long res = 0;
        HashMap<Integer, Long> counts = new HashMap<>();
        for (int i : nums) {
            int num = i - rev(i);
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1L);
            }
        }
        for (int num : counts.keySet()) {
            long count = counts.get(num);
            res = (res + (count * ((count - 1)) / 2 % 1000000007)) % 1000000007;
        }
        return (int) res;
    }

    public static int rev(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountNicePairs().countNicePairs(new int[]{1, 11, 112}));
    }
}
