package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2023/12/29 14:10
 * @Description 1493. 删掉一个元素以后全为 1 的最长子数组 1423
 */
public class Num1493_LongestSubarray {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int lastLen = 0;
        int maxlen = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                lastLen = right - left;
                left = right + 1;
            }
            right++;
            maxlen = Math.max(maxlen, right - left + lastLen);
        }
        if (left == 0) {
            maxlen--;
        }
        return maxlen;
    }
}
