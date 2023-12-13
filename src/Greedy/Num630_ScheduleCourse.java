package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2023/9/11 10:00
 * @Description LeetCode-630. 课程表 III
 * https://leetcode.cn/problems/course-schedule-iii/
 */
public class Num630_ScheduleCourse {
    /*
    思路：贪心算法，每一步做出最优解，假设当前已选课程共需n天，下一个课程怎么选？
    首先，课程之间存在优先级，结束时间晚的课放在后面选一定是比较优的，所以先按照结束时间排序
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }
}
