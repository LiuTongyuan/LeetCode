package Week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author lty
 * @Date 2024/4/17 19:20
 * @Description
 */
public class New4_17 {


    static class Union {
        HashMap<Character, Character> par;
        HashMap<Character, Long> values;

        Union() {
            par = new HashMap<>();
            values = new HashMap<>();
        }

        public char find(char c) {
            char start = c;
            char root = par.get(start);
            while (root != '*') {
                start = root;
                root = par.get(start);
            }
            //     此时start 为树根
            char cur = c;
            char p = par.get(cur);
            while (p != '*') {
                par.put(cur, start);
                cur = p;
                p = par.get(cur);
            }
            return start;

        }

        public void union(char c1, char c2, int offset, int value) {
            par.put(c1, c2);
            if (offset == 0) {
                values.put(c1, values.getOrDefault(c1, 0L) + 5 * value);
            } else {
                values.put(c1, values.getOrDefault(c1, 0L) + 2 * value);
            }
        }

        public int getLowThanM(int M) {
            HashMap<Character, Long> tmp = new HashMap<>();
            for (char c : par.keySet()) {
                long val = values.get(c);// 当前结点值
                long treeVal = tmp.getOrDefault(find(c), 0L);
                if (treeVal > M) {
                    continue;
                }
                tmp.put(find(c), val + treeVal);
            }
            int count = 0;
            for (char root : tmp.keySet()) {
                if (tmp.get(root) <= M) {
                    count++;
                }
            }
            return tmp.size() - count;
        }

        // public
    }

    /**
     * 给定多个树，树的每一个节点存在两个值,a1,a2,计算树root的权值，权值定义为：
     * （root.a1+以root为根的树的节点的a1值之和）*5+（root.a2+以root为根的树的节点的a2值之和）*2，
     * 计算权值后判断权值不超过阈值M的树的个数
     * 输入N，M表示有N组数据（N个四元组），M表示权值的阈值
     * 第一列是当前节点的名称A，第二列是A的父节点（A为根输入为*），第三列标识0，1（0表示第四列为a1，
     * 1表示第四列为a2），第四列a1/a2的值
     * （输入的数据中包含多棵树）
     * 12，40
     * a * 0 2
     * a * 1 2
     * b a 03
     * c a 1 3
     *
     * @param edges
     * @param M
     * @return
     */
    public static int two(int[][] edges, int M) {
        Union union = new Union();
        for (int i = 0; i < edges.length; i++) {
            union.union((char) edges[i][0], (char) edges[i][1], edges[i][2], edges[i][3]);
        }
        return union.getLowThanM(M);

    }

    /**
     * 在云上多个业务节点之间选择最快的逃生节点，考虑每个节点的剩余业务容量。有一个网络时延表，
     * 表示每个节点到其他节点的时延，还有一个剩余业务容量表，在一个节点故障是，选一个或多个逃生
     * 节点，确保逃生路径最小，并且逃生机诶但那集剩余容量总和能容乃故障节点的业务数量，当故障节
     * 点存在多个节点最短距离相同，选择编号小的节点逃生，逃生节点集中多个节点最短距离相同父，按
     * 从小到大排列。
     * 输入：
     * 1行n表示业务节点数，2-10000从0开始编号
     * 2-(1+n)行表示业务节点的网络时延矩阵delay
     * （1）i-j之间没有边，输入为-1，自己到自己没边，一直-1
     * （2）存边，1-1000的值
     * delay[i[j=delay[j][i]
     * (2+n)行表示每个业务节点的剩余容量表remain
     * remain范围1-100
     * (3+n)行表示故障业务节点编号fNOde，0-n-1的范
     */
    public static int three(int n, int[][] delay, int[] remain, int bug, int total) {
        HashSet<Integer> choose = new HashSet<>();
        choose.add(bug);
        int pre = bug;
        while (choose.size() < n) {
            for (int i = 0; i < n; i++) {
                if (delay[pre][i] != -1) {
                    if (delay[bug][i] == -1) {
                        delay[bug][i] = delay[bug][pre] + delay[pre][i];
                    } else {
                        delay[bug][i] = Math.min(delay[bug][i], delay[bug][pre] + delay[pre][i]);
                    }
                }

            }
            int min = Integer.MAX_VALUE;
            int ind = -1;
            for (int i = 0; i < n; i++) {
                if (!choose.contains(i) && delay[bug][i] != -1) {
                    if (delay[bug][i] < min) {
                        ind = i;
                        min = delay[bug][i];
                    }
                }

            }
            if (ind != -1) {
                pre = ind;
                choose.add(pre);
            } else {
                break;
            }

        }
        int dis = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (i == bug) {
                continue;
            }
            if (delay[bug][i] != -1 && remain[i] >= total && delay[bug][i] < dis) {
                dis = delay[bug][i];
                res = i;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[11][4];
        for (int i = 0; i < 11; i++) {
            String s = sc.nextLine();
            arr[i][0] = s.charAt(0);
            arr[i][1] = s.charAt(2);
            arr[i][2] = Integer.parseInt(s.substring(4,5).trim());
            arr[i][3] = Integer.parseInt(s.substring(6).trim());
        }
        two(arr, 40);
    }
}
