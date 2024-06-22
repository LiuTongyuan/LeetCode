package Week;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2024/4/14 19:06
 * @Description
 */
public class New4_14 {
    /**
     * 给定一个长度为N（1-10000）的字符串，只包含a-z的字母，每一个字母对应一个任务，
     * 每个任务需要时间为1，但是相同种类的任务（字母相同）需要间隔时间m才能执行，求
     * 最短执行的时间
     *
     * @param s
     * @param m
     * @return
     */
    public static int one(String s, int m) {
        m++;
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            count[charArray[i] - 'a']++;
        }
        Arrays.sort(count);
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }

        if (m >= 26) {
            int eq = 0;
            while (count[26 - eq - 1] == count[25]) {
                eq++;
            }
            return (count[25] - 1) * m + eq;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 小顶堆，先加入m个最大的
        for (int i = 0; i < m; i++) {
            priorityQueue.add(count[26 - 1 - i]);
        }
        for (int i = m; i < 26; i++) {
            // 保证只有m个数
            priorityQueue.add(priorityQueue.poll() + count[25 - i]);
        }
        int max = 0, maxCount = 0;
        for (int i = 0; i < m; i++) {
            int cur = priorityQueue.poll();
            if (cur == max) {
                maxCount++;
            } else {
                maxCount = 1;
                max = cur;
            }
        }

        return (max - 1) * m + maxCount;

    }

    /**
     * 输入一个长度为n（0-1000000）的课程数组，数组中的每个元素都是三元组，开始时间t1，结束
     * 时间t2，价值v，课程在[t1,t2)之间执行，求课程不冲突的情况下，价值最大
     * TODO:如果没有以时间i为结尾的课程，时间dp[i]会错误为0
     * @param nums
     * @return
     */
    public static int two(int[][] nums) {
        // 按照结束时间排序
        Arrays.sort(nums, (int[] a, int[] b) -> a[1] - b[1]);
        // 以时间i结束
        int[] dp = new int[nums[nums.length - 1][1] + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i][1]] = Math.max(dp[nums[i][0]] + nums[i][2], dp[nums[i][1]]);
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 32位的符号整数，按位反转，输出反装结果，输入123，输出321，
     * 输入-123，输出-321，输入120，输出21，反转后的数溢出int，返回为0
     *
     * @return
     */

    public static int three(int a) {
        // TODO:溢出
        boolean pos = false;
        if (a == 0) {
            return 0;
        }
        if (a > 0) {
            pos = true;
        } else {
            a = -a;
        }
        long res = 0;
        while (a > 0) {
            res = res * 10 + a % 10;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            a = a / 10;
        }
        return pos ? (int) res : -(int) res;
    }


    public static void main(String[] args) {
        one("aaabbb", 2);
        three(-1234567899);
    }
}
