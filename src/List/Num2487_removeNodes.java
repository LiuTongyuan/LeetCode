package List;

import java.util.List;

/**
 * @Author lty
 * @Date 2024/1/3 14:52
 * @Description 2487. 从链表中移除节点
 */
public class Num2487_removeNodes {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        // 逆序
        ListNode revList = reverseList(head);
        // 删除
        ListNode start = revList;
        while (start != null) {
            while (start.next != null && start.val > start.next.val) {
                start.next = start.next.next;
            }
            start = start.next;
        }
        return reverseList(revList);
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy.next.next, temp = null;
        head.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
