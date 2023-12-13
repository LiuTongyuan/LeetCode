package DP.SubString;

/**
 * @Author 年年
 * @Date 2021/12/14 10:59
 * @Description LeetCode-1278:分割回文串 III
 * 可以修改s的字符，返回将s分割为k个回文串需要修改的字符数的最小值
 */
public class PalindromeSubstring {
    /**
     * 方法一：int[][] dp[i][j]表示将前i个字符分割为j个回文串所需要的最小修改次数。
     * int[][] change[m][n]表示将s.subString(m,n+1)修改为回文串所需要的最小修改次数
     * 递推公式：dp[i][j] = Math.min{dp[m][j-1]+change[m+1][i] | m=j-1...i-1}
     *
     * @param s
     * @param k
     * @return
     */
    public int palindromePartition(String s, int k) {
        //求change
        int[][] change = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    change[i][j] = 0;
                } else if (s.charAt(i) == s.charAt(j)) {
                    change[i][j] = (j == i + 1) ? 0 : change[i + 1][j - 1];
                } else {
                    change[i][j] = (j == i + 1) ? 1 : change[i + 1][j - 1] + 1;
                }
            }
        }
        //求dp
        int[][] dp = new int[s.length()][k + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j == 1) {
                    dp[i][j] = change[0][i];
                } else if (i <= j - 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int m = j - 2; m < i; m++) {
                        dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + change[m + 1][i]);
                    }
                }

            }
        }
        return dp[s.length() - 1][k];
    }

    //求dp过程的错误写法
    public void getdp(String s, int k) {
        //求change
        int[][] change = new int[s.length()][s.length()];
        //求dp
        int[][] dp = new int[s.length()][k + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < k + 1; j++) {
                //错误在这里
                //错误原因：dp[i][j]的默认值不应该是change[0][i]，因为
                //假设“aea”，其change[0][2]=0，但是如果dp[2][2]直接
                //取change[0][2]=0，那么不管怎么分后续为0了，但是显然，如果分成两份，不可能为0
                dp[i][j] = change[0][i];
                if (i <= j - 1) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int m = j - 2; j > 1 && m < i; m++) {
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + change[m + 1][i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new PalindromeSubstring().palindromePartition("aea", 2));
    }
}
