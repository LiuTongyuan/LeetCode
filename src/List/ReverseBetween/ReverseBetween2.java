package List.ReverseBetween;

import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/6/2 10:55
 * @Description 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class ReverseBetween2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy;
        for (int i = 1; i < left; i++) {
            start = start.next;
        }
        ListNode cur = start.next,buffer;
        for (int i = right - left; i > 0; i--) {
            buffer = cur.next;
            cur.next = buffer.next;
            buffer.next = start.next;
            start.next = buffer;
        }

        return dummy.next;
    }
}
