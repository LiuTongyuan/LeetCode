package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2023/12/30 19:57
 * @Description 1004. 最大连续1的个数 III 1656
 */
public class Num1004_longestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0, maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            if (count > k) {
                while (count > k) {
                    if (nums[left] == 0) {
                        count--;
                    }
                    left++;
                }
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
