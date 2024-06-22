package SlidingWindow.NoDefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/29 14:00
 * @Description 3. 无重复字符的最长子串
 */
public class Num3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] index = new int[256];
        int maxLen = 0;
        Arrays.fill(index, -1);
        while (right < s.length()) {
            if (index[s.charAt(right)] >= left) {
                left = index[s.charAt(right)] + 1;
            }
            index[s.charAt(right)] = right;
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
