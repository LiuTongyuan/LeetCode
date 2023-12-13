package Map.Topology;

import java.util.HashSet;

/**
 * @Author lty
 * @Date 2023/9/9 11:10
 * @Description 207. 课程表
 * https://leetcode.cn/problems/course-schedule/solutions/359392/ke-cheng-biao-by-leetcode-solution/
 */
public class CanFinish {
    /*
    题解：一门课程可以为学习另一门课程的先决条件，因此判断为拓扑排序问题。
    思路：把每门课程当做一个顶点，统计每门课程的入度，入度为0则可以进行遍历。学习后需将对应后续课程的入度-1。
    若最终所有课程均可以学习，那么判断为true，反之false。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] entry = new int[numCourses];
        for (int[] prereq : prerequisites) {
            entry[prereq[1]]++;
        }
        HashSet<Integer> visited = new HashSet<>();
        boolean hasTraveled = true;
        while (hasTraveled) {
            hasTraveled = false;
            for (int i = 0; i < entry.length; i++) {
                if (entry[i] == 0 && !visited.contains(i)) {
                    for (int[] prereq : prerequisites) {
                        if (prereq[0] == i) {
                            entry[prereq[1]]--;
                        }
                    }
                    visited.add(i);
                    hasTraveled = true;
                    break;
                }
            }
        }
        return visited.size() == numCourses;
    }

}
