package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2023/12/29 10:56
 * @Description 2706. 购买两块巧克力 1208
 */
public class Num2706_BuyChoco {
    public int buyChoco(int[] prices, int money) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        heap.add(prices[0]);
        heap.add(prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < heap.peek()) {
                heap.poll();
                heap.add(prices[i]);
            }
        }
        int total = heap.poll() + heap.poll();
        return total > money ? money : money - total;
    }
}
