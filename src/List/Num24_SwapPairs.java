package List;

/**
 * @Author 年年
 * @Date 2022/7/5 10:12
 * @Description
 */
public class Num24_SwapPairs {
    /**
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy, buf;
        while (cur.next != null && cur.next.next != null) {
            buf = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            buf.next = cur.next;
            cur.next = buf;
            cur = buf;
        }
        return dummy.next;
    }
}
