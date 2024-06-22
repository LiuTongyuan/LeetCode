package Week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2024/4/28 10:20
 * @Description
 */
public class New4_28 {
    /**
     * 2.玩家有很多任务，每个任务有截止日期，不同的任务有不同的奖励，玩家有减负券，使用减负券可以直接完成一个任务，如何安排减负券的使用，以获得最多奖励。
     * 输入：第一行n,m表示有那个任务，m天时间
     * 再输入n行，每行两个正整数，val和limit（都是0-1000000），表示奖励和截止日期。
     * 再输入M行，每行表示每一天减负券的个数
     * 输出玩家能够获得的最多奖励
     *
     * @return
     */
    public static int two(int[][] task, int[] coupons) {
        // 按照截止日期排序
        Arrays.sort(task, (a, b) -> {
            return a[1] - b[1];
        });
        // 每张券只能完成他发布后的任务
        // 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int res = 0;
        int cur = task.length - 1;
        for (int i = coupons.length - 1; i >= 0; i--) {
            while (cur >= 0 && task[cur][1] >= i) {
                heap.add(task[cur][0]);
                cur--;
            }
            for (int j = 0; !heap.isEmpty() && j < coupons[i]; j++) {
                res += heap.poll();
            }

        }
        return res;
    }

    /**
     * 青年和老虎在海上漂流，需要食物和水才能存活，青年每天需要1份食物两2水，老虎需要2份食物1份水，只有在没有食物和水是才能不吃，老虎不吃P天后，将会把人吃掉，人类不吃Q天后将会死去。
     * 不足一天的食物和水，忽略不计。
     * 小船的大小为x，n份食物，m份水，要求n+3m<=x
     * 输入P，Q，x，输出青年人类能够存活的最大天数
     */
    public static int three(int P, int Q, int x) {
        //     P-1天后老虎开始吃，Q-1天后人开始吃计算函数就行。
        if (P > Q) {
            // 人先开始吃
            if (7 * (P - Q) > x) {
                //     不足以支撑到老虎
                return x / 7 + Q;
            } else {
                return (x - (P - Q) * 7) / 12 + P;
            }
        } else {
            //     老虎先开始吃
            if (5 * (Q - P) > x) {
                //     不足以支撑到人
                return x / 5 + P;
            } else {
                return (x - (Q - P) * 5) / 12 + Q;
            }
        }
    }

    /**
     * 在一个高维空间，空间中有一些只能踏足一次的量姿态，在踏足一次并离开后改量姿态就会湮灭为信息太。
     * 某些量子台之间存在双向传送门，可以在两个量子台之间移动，经过传送门会受到精神伤害。
     * <p>
     * 从当前量子台出发，到某块量子台拿钥匙，并前往出口，打开出口。
     * 量姿态的数量为n，双向传送门的数量为m，第i个传送门需要承受的精神伤害为wi，起始量子台s，钥匙在e，
     * 出口在t，不存在自环，s，e，t互不相同。
     * 输入：第一行：n,m,s,e,t
     * 后m行，输入u，v，w表示uv之间有传送门，需要受伤为w
     * 输出：输出一个整数，表示需要承受的最少精神伤害或者输出-1，表示无法取得钥匙到达出口
     * <p>
     * n和m都是1-20000
     * wi是0-10^9
     *
     * @return
     */
    public static int four(int[][] edges, int n, int s, int e, int t) {
        ArrayList[] next = new ArrayList[n + 1];
        for (int i = 0; i < next.length; i++) {
            next[i] = new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            next[edges[i][0]].add(edges[i][1]);
            next[edges[i][1]].add(edges[i][0]);
        }
        return -1;
    }

    public static void main(String[] args) {
        // two(new int[][]{{3, 1}, {5, 3}, {4, 2}, {6, 4}}, new int[]{1, 1, 1});
        // int a = three(8,7,37);

    }
}
