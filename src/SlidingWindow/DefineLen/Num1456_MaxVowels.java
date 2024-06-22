package SlidingWindow.DefineLen;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author lty
 * @Date 2023/12/27 16:12
 * @Description 1456. 定长子串中元音的最大数目
 */
public class Num1456_MaxVowels {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int total = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                total++;
            }
        }
        int max = total;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                total++;
            }
            if (set.contains(s.charAt(i - k))) {
                total--;
            }
            max = Math.max(max, total);
        }
        return max;
    }

}
