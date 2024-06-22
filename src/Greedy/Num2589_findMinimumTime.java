package Greedy;

/**
 * @Author lty
 * @Date 2024/5/15 11:20
 * @Description 2589. 完成所有任务的最少时间
 * https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/description/
 */
public class Num2589_findMinimumTime {
    /**
     * 方法一：贪心：首先对任务进行排序，按照结束时间排序，每个任务先判断有多少已有节点
     * @param tasks
     * @return
     */
    public static  int findMinimumTime(int[][] tasks) {

        int count = 0;
        for (int i = 0; i < 100; i++) {
            count = count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumTime(null));
    }
}
