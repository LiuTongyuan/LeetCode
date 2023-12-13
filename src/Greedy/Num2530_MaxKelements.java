package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2023/10/18 10:12
 * @Description 2530. 执行 K 次操作后的最大分数
 * https://leetcode.cn/problems/maximal-score-after-applying-k-operations/description/
 */
public class Num2530_MaxKelements {
    /**
     * 题解：比较简单的贪心算法，每次选取最大的就行
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            int cur = maxHeap.poll();
            res += cur;
            cur = (int) Math.ceil(cur / 3.0);
            maxHeap.add(cur);
        }
        return res;
    }
}
