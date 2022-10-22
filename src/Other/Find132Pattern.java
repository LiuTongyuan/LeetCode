package Other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author lty
 * @Date 2022/10/21 14:08
 * @Description
 */
public class Find132Pattern {
    public static void main(String[] args) {
        new Find132Pattern().find132pattern2(new int[]{3,5,0,3,4});
    }
    /**
     * 方法一：暴力枚举
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int[] findLessBefore = new int[nums.length];
        int min_value = Integer.MAX_VALUE;
        min_value = Math.min(min_value, nums[0]);

        for (int i = 0; i < nums.length; i++) {
            if (min_value < nums[i]) {
            } else {
                min_value = nums[i];
            }
            findLessBefore[i] = min_value;
        }
        min_value = Math.max(min_value, nums[nums.length - 1]);
        for (int i = nums.length - 1; i > 0; i--) {
            if (min_value < nums[i]) {
                if (findLessBefore[i] < min_value) {
                    return true;
                }
            } else {
                min_value = nums[i];
            }
        }
        return false;
    }

    /**
     * 方法二：单调栈
     *
     * @param nums
     * @return
     */
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }
        return false;
    }
}
