package DP;

/**
 * @Author 年年
 * @Date 2021/12/17 11:05
 * @Description 面试题17.16-按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约
 * 请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 和打家劫舍I基本一致
 */
public class Massager {
    /**
     * int[][]
     * dp[i][0] 表示在前i个子序列中，不选第i个可获得最大预约时长
     * dp[i][1] 表示在前i个子序列中，选第i个可获得最大预约时长
     * <p>
     * 递推公式：
     * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
     * dp[i][1] = dp[i-1][0]+ nums[i]
     * <p>
     * 使用空间优化
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int choose = nums[0], notChoose = 0;
        for (int i = 1; i < nums.length; i++) {
            int oldNotChoose = notChoose;
            notChoose = Math.max(notChoose, choose);
            choose = oldNotChoose + nums[i];
        }
        return Math.max(choose, notChoose);
    }
}
