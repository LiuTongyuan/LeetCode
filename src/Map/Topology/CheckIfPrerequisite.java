package Map.Topology;

import java.util.*;

/**
 * @Author lty
 * @Date 2023/9/15 09:42
 * @Description
 */
public class CheckIfPrerequisite {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        // 统计入度
        int[] indgree = new int[numCourses];
        for (int[] p : prerequisites) {
            indgree[p[1]]++;
            isPre[p[0]][p[1]] = true;
        }
        // 遍历队列
        Deque<Integer> canTra = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0){
                canTra.offer(i);
            }
        }
        while (canTra.size()!=0){
            int num = canTra.poll();
        }


        return null;
    }
}
