package DP;

import java.util.HashSet;

/**
 * @Author lty
 * @Date 2024/1/9 09:30
 * @Description 2707. 字符串中的额外字符
 */
public class Num2707_minExtraChar {
    /**
     * dp[i] 表示以 s[i] 结尾的字符串的最少剩余
     * 则dp[i]可分为两个问题：
     * 1. 选择s[i]
     * dp[i] = dp[j-1] (s[j,i]在字典中,j = 0...i)
     * 2. 不选s[i]
     * dp[i] = dp[i-1] + 1;
     * <p>
     * 此时j可以取0 所以得加一个，用0表示-1；
     * dp[i] 表示以 s[i-1] 结尾的字符串的最少剩余
     * dp[i] = dp[j-1] (s[j,i-1]在字典中,j = 1...i)
     *
     * @param s
     * @param dictionary
     * @return
     */
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
        for (int i = 1; i < dp.length; i++) {
            // 不选第i个字符
            dp[i] = dp[i - 1] + 1;
            // 选第i个字符
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))){
                    dp[i] = Math.min(dp[i], dp[j]);
                }

            }
        }
        return dp[dp.length - 1];
    }


}
