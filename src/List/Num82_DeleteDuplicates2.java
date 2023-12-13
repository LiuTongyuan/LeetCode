package List;

import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/2/28 9:11
 * @Description 82 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Num82_DeleteDuplicates2 {
    /**
     * 注意：仅保留未重复出现的元素，而不是每个保留一个。
     * 需要考虑：
     * 1.链表可能被删空
     * 2.头部节点可能被删除
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy, right = dummy.next;
        while (right != null) {
            if (right.next == null || right.next.val != left.next.val) {
                if (left.next != right) {
                    left.next = right.next;
                    right = right.next;
                } else {
                    left = left.next;
                    right = right.next;
                }
            } else {
                right = right.next;
            }
        }
        return dummy.next;
    }
}
