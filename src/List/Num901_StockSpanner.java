package List;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author lty
 * @Date 2023/10/7 11:16
 * @Description LeetCode-https://leetcode.cn/problems/online-stock-span/description/
 * https://leetcode.cn/problems/online-stock-span/description/
 */
public class Num901_StockSpanner {
    class StockSpanner {
        private Deque<Integer> stocks;
        private Deque<Integer> res;
        private int count;

        public StockSpanner() {
            stocks = new ArrayDeque<Integer>();
            res = new ArrayDeque<Integer>();
            count = 1;
        }

        public int next(int price) {
            while (stocks.size() != 0 && (stocks.peek() <= price)) {
                stocks.pop();
                res.pop();
            }
            int lastInd = 0;
            if (stocks.size() == 0) {
                stocks.push(price);
                res.push(count);
            } else {
                stocks.push(price);
                lastInd = res.peek();
                res.push(count);
            }
            count++;
            return count - lastInd - 1;
        }
    }
}
