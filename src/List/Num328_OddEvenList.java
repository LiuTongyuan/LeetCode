package List;

/**
 * @Author lty
 * @Date 2023/10/5 13:26
 * @Description LeetCode-328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/description/
 */
public class Num328_OddEvenList {
    /**
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode oddCur = oddHead, evenCur = evenHead;
        while (head != null && head.next != null) {
            // 每次处理两个连续的非空节点
            oddCur.next = head;
            evenCur.next = head.next;
            head = head.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        if (head != null) {
            // 是否剩下单独的，如果有，单独追加到奇数列表
            oddCur.next = head;
            oddCur = oddCur.next;
        }
        oddCur.next = evenHead.next;
        evenCur.next = null;
        return oddHead.next;
    }
}
