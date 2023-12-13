package List;

import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/6/2 10:55
 * @Description LeetCode-92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class Num92_ReverseBetween2 {
    /**
     * 共三种方法，本项目实现两种：
     * 1.头插法
     * 2.while循环
     *
     * @param head  链表头节点
     * @param left  反转 起始索引
     * @param right 反转 结束索引
     * @return
     */

    // 1.头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // d f 2 c 3 4 5
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy, cur, buf;
        for (int i = 1; i < left; i++) {
            start = start.next;
        }
        cur = start.next;
        while ((right--) > left) {
            buf = cur.next;
            cur.next = buf.next;
            buf.next = start.next;
            start.next = buf;
        }
        return dummy.next;
    }

    // 2.while循环
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        for (int i = 1; i < left; i++) {
            start = start.next;
        }
        ListNode pre = start.next, cur = pre.next, buf = null;
        while ((right--) > left) {
            buf = cur.next;
            cur.next = pre;
            pre = cur;
            cur = buf;
        }
        start.next.next = cur;
        start.next = pre;

        return dummy.next;
    }
}
