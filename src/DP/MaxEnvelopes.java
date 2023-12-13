package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 年年
 * @Date 2021/12/15 11:47
 * @Description LeetCode-354:俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大(注意不能相等)的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 */
public class MaxEnvelopes {
    /**
     * 方法一：dp
     * 理解：对于这种两个维度都要比较大小的问题，我们可以考虑一个维度升序，一个维度降序，比如
     * 在第一个属性上升序，第二个维度降序，后续我们从前至后遍历的时候，可以只比较第二个维度的大
     * 因为对于<i,j>两个位置的元素 nums[i][0]<=nums[j][0],一定成立。此时只要nums[i][1]
     * >=nums[j][1],则可以说第j个元素大于第i个元素，因为此时我们在第二个位置使用降序，所以不会
     * 出现{<6,7><6,8><6,9>}之类的序列，只会有{<6,9><6,8><6,7>},这样不会判定<6,8>比<6,7>大，
     * 符合题目要求的大于的定义
     * <p>
     * int[] dp[i] 表示以第i个信封收尾时最多叠加几次
     * 递推公式：
     * dp[i] = Math.max{dp[i],dp[j = 0...i]+1} | (envelopes[i]>envelopes[j])
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max + 1;
    }

    /*
    * 方法二：优化,dp+二分查找
    * */
}