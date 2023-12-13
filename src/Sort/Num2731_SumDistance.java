package Sort;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/10/10 10:56
 * @Description 2731. 移动机器人
 * https://leetcode.cn/problems/movement-of-robots/
 */
public class Num2731_SumDistance {
    public static void main(String[] args) {
        new Num2731_SumDistance().sumDistance(new int[]{-10, -13, 10, 14, 11}, "LRLLR", 2);
    }

    /**
     * 思路：本题难点主要在于求距离和
     * 排序后从左向右求和假设现在有 x1 x2 ... xn-1 xn
     * xn 和其他点的和可以用 xn-1 和其他点的和 以及 (n-1)(xn - xn-1)获得
     *
     * @param nums
     * @param s
     * @param d
     * @return
     */
    public int sumDistance(int[] nums, String s, int d) {
        long[] numsBuf = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'R') {
                numsBuf[i] = nums[i] + d;
            } else {
                numsBuf[i] = nums[i] - d;
            }
        }
        Arrays.sort(numsBuf);
        long sum = 0, lastDis = 0;
        for (int i = 1; i < numsBuf.length; i++) {
            lastDis += i * (numsBuf[i] - numsBuf[i - 1]) % 1000000007;
            sum = (sum + lastDis) % 1000000007;
        }
        return (int) sum;
    }
}
