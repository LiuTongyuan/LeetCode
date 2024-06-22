package Hash;

import DP.Num115_numDistinct;

/**
 * @Author lty
 * @Date 2024/4/5 19:49
 * @Description
 */
public class Num287_findDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }
        return 0;
    }
}
