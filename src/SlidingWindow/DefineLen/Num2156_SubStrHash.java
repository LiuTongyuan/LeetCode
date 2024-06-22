package SlidingWindow.DefineLen;

import java.io.PipedWriter;

/**
 * @Author lty
 * @Date 2023/12/28 11:06
 * @Description 2156. 查找给定哈希值的子串 2063
 */
public class Num2156_SubStrHash {
    // TODO:

    public static void main(String[] args) {
        new Num2156_SubStrHash().subStrHash("xmmhdakfursinye", 96, 45, 14, 21);
        // new Num2156_SubStrHash().subStrHash("leetcode", 7, 20, 2, 0);
    }

    // public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    //     long temp = 0;
    //     long weight = (long) Math.pow(power, k - 1) % modulo;
    //     for (int i = 0; i < k; i++) {
    //         temp = temp / power + (s.charAt(i) - 'a' + 1) * weight % modulo;
    //     }
    //     if (temp == hashValue) {
    //         return s.substring(0, k);
    //     }
    //     for (int i = k; i < s.length(); i++) {
    //         temp = ((temp - s.charAt(i - k) + 'a' - 1) / power + (s.charAt(i) - 'a' + 1) * weight) % modulo;
    //         if (temp % modulo == hashValue) {
    //             return s.substring(i - k + 1, i + 1);
    //         }
    //     }
    //     return null;
    // }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long mutl = (long) Math.pow(power, k - 1) % modulo;
        long h = 0;
        int index = 0;
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i > str.length - 1 - k; i--) {
            h = (h * power % modulo + str[i] - 'a' + 1) % modulo;
        }
        if (h == hashValue) {
            index = str.length - k;
        }
        for (int i = str.length - 1 - k; i >= 0; i--) {
            h = ((h - (str[i + k] - 'a' + 1) * mutl) * power % modulo + str[i] - 'a' + 1) % modulo;
            if (h == hashValue) {
                index = i;
            }
        }
        return s.substring(index, index + k);

    }
}
