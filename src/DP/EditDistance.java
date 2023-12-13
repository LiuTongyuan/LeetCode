package DP;

/**
 * @Author 年年
 * @Date 2021/12/19 10:14
 * @Description LeetCode-72:编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 本质上还是两个一维数组的dp问题
 */
public class EditDistance {
    /**
     * 方法一：
     * 给word1插入相当于给word2删除，给word2插入相当于给word1删除，给word1修改相当于给word2修改；
     * 因此，最终只有三种操作
     * 给word1删除，给word2删除，给word1修改；
     * <p>
     * int[][] dp = new int[word1.length() + 1][word2.length() + 1];
     * dp[i][j] 表示 word1.subString(0,i)和word2.subString(0,j)的编辑距离
     * 因此递推公式：
     * 1.word1[i] == word2[j]
     * dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
     * 2.word1[i] != word2[j]
     * dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
