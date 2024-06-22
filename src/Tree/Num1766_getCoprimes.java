package Tree;

import java.util.*;

/**
 * @Author lty
 * @Date 2024/4/11 20:54
 * @Description
 */
public class Num1766_getCoprimes {
    public static void main(String[] args) {
        gcd(3, 5);
        getCoprimes(new int[]{2, 3, 3, 2}, new int[][]{{0, 1}, {1, 2}, {2, 3}});
    }

    public static int[] getCoprimes(int[] nums, int[][] edges) {
        int[] res = new int[nums.length];
        // 每个点最多与三个点相连
        int[][] next = new int[nums.length][3];
        for (int i = 0; i < next.length; i++) {
            Arrays.fill(next[i], -1);
        }
        for (int e = 0; e < edges.length; e++) {
            addEdge(next[edges[e][0]], edges[e][1]);
            addEdge(next[edges[e][1]], edges[e][0]);
        }
        dfs(nums, new int[nums.length], next, 0, new ArrayList<>(), new HashSet<>());
        return res;

    }

    public static void dfs(int[] nums, int[] res, int[][] next, int root, ArrayList<Integer> path, HashSet<Integer> visited) {
        if (visited.contains(root)) {
            return;
        }
        visited.add(root);
        for (int i = path.size() - 1; i >= 0; i++) {
            if (gcd(nums[path.get(i)], nums[root]) == 1) {
                res[root] = i;
            }
        }
        path.add(root);
        for (int i = 0; i < next[root].length; i++) {
            dfs(nums, res, next, next[root][i], path, visited);
        }
        path.remove(path.size() - 1);
    }

    public static void addEdge(int[] next, int to) {
        for (int i = 0; i < next.length; i++) {
            if (next[i] == -1) {
                next[i] = to;
                return;
            }
        }
    }

    public static int gcd(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;

    }
}
