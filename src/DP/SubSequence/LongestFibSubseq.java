package DP.SubSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 年年
 * @Date 2021/12/15 10:11
 * @Description 剑指OfferII-093:最长斐波那契数列
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
 */
public class LongestFibSubseq {
    /**
     * 方法一：int[][] dp[i][j]表示以 arr[i],arr[j]开头的最长的斐波那契子序列长度。
     * 三层遍历加剪枝
     * 递推公式：
     * arr[i] + arr[j] = arr[k]
     * dp[i][j] = dp[j][k] + 1
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int max = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] == arr[k]) {
                        dp[i][j] = dp[j][k] + 1;
                        max = Math.max(max, dp[i][j]);
                    } else if (arr[i] + arr[j] < arr[k]) {
                        break;
                    }
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }

    /**
     * 优化，预处理，将arr[i]和对应的索引i存入HashMap
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq2(int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int max = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                int num = arr[i] + arr[j];
                if (indexMap.containsKey(num)) {
                    dp[i][j] = dp[j][indexMap.get(num)] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }

    public static void main(String[] args) {
        System.out.println(new LongestFibSubseq().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
