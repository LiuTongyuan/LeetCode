package SlidingWindow.DefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/28 10:46
 * @Description
 */
public class Num567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }
        if (getMax(count) <= 0) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (getMax(count) <= 0) {
                return true;
            }
        }
        return false;
    }

    public int getMax(int[] count) {
        int max = count[0];
        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
