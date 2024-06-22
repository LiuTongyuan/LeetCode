package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author lty
 * @Date 2024/1/5 09:59
 * @Description 1944. 队列中可以看到的人数 2105
 * 单调栈
 */
public class Num1944_canSeePersonsCount {
    public int[] canSeePersonsCount(int[] heights) {
        return m1(heights);
    }

    /**
     * dp[i] 存储 heights 中 i位置后 下一个比 i 大的元素
     * dp[i] = dp.length 表示后续没有比当前位置高的元素，跳出循环
     * res 存储结果
     *
     * @param heights
     * @return
     */
    public int[] m1(int[] heights) {
        int[] dp = new int[heights.length];
        int[] res = new int[heights.length];
        // 利用dp.length 表示后续没有比当前位置高的元素，跳出循环
        Arrays.fill(dp, dp.length);
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; ) {
                if (heights[i] > heights[j]) {
                    j = dp[j];
                    res[i]++;
                } else {
                    dp[i] = j;
                    res[i]++;
                    break;
                }
            }
        }
        dp[dp.length - 1] = 0;
        return res;
    }

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public int[] m2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[heights.length];
        for (int i = res.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(i);
        }
        res[res.length - 1] = 0;
        return res;
    }
}
