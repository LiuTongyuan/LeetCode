package List;

/**
 * @Author 年年
 * @Date 2022/7/8 9:59
 * @Description 19. 删除链表的倒数第 Week396 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Num19_RemoveNthFromEnd {

    /**
     * 需考虑以下情况：
     * 1.删除头结点(易忽略导致出错)
     * 2.删除尾结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return m2(head, n);
    }

    /**
     * 方法一：统计链表长度
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode m1(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode buf = dummy;
        int count = 0;
        while (buf != null) {
            count++;
            buf = buf.next;
        }
        buf = dummy;
        for (int i = count - n - 1; i > 0; i--) {
            buf = buf.next;
        }

        buf.next = buf.next.next;
        return dummy.next;
    }

    /**
     * 方法二：双指针找倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode m2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 方法三：递归，逆序遍历链表
     * 和用栈没区别
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode m3(ListNode head, int n) {
        return null;
    }
}
