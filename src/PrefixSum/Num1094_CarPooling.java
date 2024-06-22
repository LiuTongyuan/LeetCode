package PrefixSum;

/**
 * @Author lty
 * @Date 2023/12/15 10:44
 * @Description 1094. 拼车
 * https://leetcode.cn/problems/car-pooling/description/
 */
public class Num1094_CarPooling {
    /**
     * 前缀和、差分数组
     * 统计每个站点的人数变更情况，作为人数的导数，最后依次求和，只要过程中不超载即可。
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        int[] diff = new int[max + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int nowCap = 0;
        for (int i = 0; nowCap <= capacity && i < diff.length; i++) {
            nowCap += diff[i];
        }
        return nowCap == 0;
    }
}
