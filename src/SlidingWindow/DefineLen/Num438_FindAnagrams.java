package SlidingWindow.DefineLen;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lty
 * @Date 2023/12/28 10:58
 * @Description 438. 找到字符串中所有字母异位词
 */
public class Num438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }
        if (getMax(count) <= 0) {
            list.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - p.length()) - 'a']++;
            if (getMax(count) <= 0) {
                list.add(i - p.length() + 1);
            }
        }
        return list;


    }

    public int getMax(int[] count) {
        int max = count[0];
        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
