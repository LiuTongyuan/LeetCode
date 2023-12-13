package Search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/9/7 10:12
 * @Description 2594. 修车的最少时间
 * https://leetcode.cn/problems/minimum-time-to-repair-cars/
 */
public class RepairCars {
    /*
    错误的：
    解题思路：因为时间计算公式是固定的，所以可以参考函数求导判断变化。
    每次去找当前时间最长的，去想办法减小它的时间，其实也就是贪心算法，但是这样相当于一辆车一辆车分配，很容易闭环死锁。
    同时当车辆多时，计算量会很大。
     */
    public static long repairCars1(int[] ranks, int cars) {
        int[] nums = new int[ranks.length];
        int avg = cars / ranks.length;
        // 初始化 均分汽车
        for (int i = 0; i < nums.length; i++) {
            nums[i] = avg;
        }
        nums[nums.length - 1] = cars - (nums.length - 1) * avg;
        int maxIndex = findMaxIndex(ranks, nums);
        boolean changed = false;
        while (true) {
            // 当前结果
            changed = false;
            int result = ranks[maxIndex] * nums[maxIndex] * nums[maxIndex];
            for (int i = 0; i < nums.length; i++) {
                if (ranks[i] * (nums[i] + 1) * (nums[i] + 1) < result) {
                    nums[maxIndex]--;
                    nums[i]++;

                    maxIndex = findMaxIndex(ranks, nums);
                    changed = true;
                    break;
                }
            }
            if (!changed) {
                return result;
            }

        }
    }

    public static int findMaxIndex(int[] ranks, int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (ranks[i] * nums[i] * nums[i] > ranks[result] * nums[result] * nums[result]) {
                result = i;
            }
        }
        return result;
    }

    /*
    正解，因为其实当在t时间内可以完成修理时。可能有的师傅用时小于t，假设他们把时间用完，那么可以修理的车辆数一定超过目标
    所以，我们可以假设每个师傅都把时间用光，这样分别计算每个师傅可以修理的车数即可
    在计算时间时，我们可以采用二分计算。保证下限时间内完不成，上限时间内可以完成即可。

    可优化：初始化时，本题采用了右边界Long.MAX_VALUE，但其实可以使用ranks[0] * cars * cars，它一定满足要求。
     */
    public static long repairCars(int[] ranks, int cars) {
        long high = Long.MAX_VALUE, low = 0L;
        while (low < high) {
            long middle = (high + low) / 2;
            if (check(ranks, cars, middle)) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return high;
    }

    public static boolean check(int[] ranks, int cars, long time) {
        long count = 0;
        for (int i = 0; i < ranks.length; i++) {
            count += Math.sqrt(time / ranks[i]);
        }
        return count >= cars;
    }


    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10));
    }
}
