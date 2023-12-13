package List;

/**
 * @Author lty
 * @Date 2023/10/12 09:51
 * @Description LCR 136. 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Num136_DeleteNode {
    /**
     * 注意：可能删除到头节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        while (start.next != null) {
            if (start.next.val == val) {
                start.next = start.next.next;
                break;
            }
            start = start.next;
        }
        return dummy.next;
    }
}
