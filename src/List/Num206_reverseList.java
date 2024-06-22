package List;

/**
 * @Author lty
 * @Date 2024/1/4 11:05
 * @Description
 */
public class Num206_reverseList {
    public ListNode reverseList(ListNode head) {
        return m2(head);
    }

    public ListNode m1(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;

        }
        return dummy.next;
    }

    public ListNode m2(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
