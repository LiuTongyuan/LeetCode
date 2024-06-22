package List;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author lty
 * @Date 2023/10/12 10:26
 * @Description 1019. 链表中的下一个更大节点
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 */
public class Num1019_NextLargerNodes {
    /**
     * 方法一：栈
     * 使用单调递减栈，当 cur < 栈顶，直接入栈，否则一直出栈到 栈顶 > cur，出栈的元素的下一个更大节点就是cur
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<Integer>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        int[] res = new int[nums.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && nums.get(stack.peek()) < nums.get(i)) {
                res[stack.pop()] = nums.get(i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

    /**
     * 方法2：剪枝计算，从后向前
     * res[i]记录下一个比nums[i]大的 元素下标
     * 1.nums[i] < nums[next]:找到了下一个更大 res[i] = next
     * 2.nums[i] >= nums[next]:没找到
     *      a.res[next]==0:此时后面没有比nums[next]更大的元素，自然也就没有比nums[i]大的
     *          res[i] = 0;
     *      b.res[next]!=0:此时后面有比nums[next]更大的元素，需要比较
     *          nums[res[next]] <= nums[i]
     *              此时令 next = res[next]
     *          nums[res[next]] > nums[i]
     *              此时令 res[j] = res[next]
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes2(ListNode head) {
        List<Integer> buf = new ArrayList<Integer>();
        while (head != null) {
            buf.add(head.val);
            head = head.next;
        }
        Integer[] nums = buf.toArray(new Integer[0]);
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int next = i + 1;
            while (next < nums.length) {
                if (nums[i] < nums[next]) {
                    res[i] = next;
                    break;
                }
                if (res[next] == 0) {
                    res[i] = 0;
                    break;
                } else if (nums[i] < nums[res[next]]) {
                    res[i] = res[next];
                    break;
                } else {
                    next = res[next];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] == 0 ? 0 : nums[res[i]];
        }
        return res;
    }
}
