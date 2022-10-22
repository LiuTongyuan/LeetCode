package List.DeleteDuplicates;

import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/6/2 10:47
 * @Description 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {
    /**
     * 需要考虑：
     * 1.链表可能被删空
     * 2.头部节点可能被删除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode left = dummy;
        while (left.next != null) {
            if (left.val != left.next.val) {
                left = left.next;
            } else {
                left.next = left.next.next;
            }
        }
        return dummy.next;
    }
}
