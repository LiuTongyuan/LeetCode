package SlidingWindow.NoDefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/4/8 12:58
 * @Description
 * 2009. 使数组连续的最少操作数
 */
public class Num2009_minOperations {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        // 滑动可变大小窗口 头尾差值不超过nums.len 找窗口可容纳的最大不同的数字，需考虑进和出
        // left表示下一个要去除的数字，right表示下一个要添加的数字。
        int left = 0, right = 1, maxCount = 1, count = 1;
        while (right < nums.length) {
            // 每次先进一个，相当于确定right
            // 进的数字是没有出现过的，那么count++
            if (nums[right] != nums[right - 1]) {
                count++;
            }

            while (nums[right] - nums[left] > nums.length - 1) {
                left++;
                if (nums[left] != nums[left - 1]) {
                    // 有一个数字全部被舍去，则窗口内的 不同数字数count--；
                    count--;
                }
            }
            right++;
            maxCount = Math.max(count, maxCount);
        }


        return nums.length - maxCount;

    }
}
